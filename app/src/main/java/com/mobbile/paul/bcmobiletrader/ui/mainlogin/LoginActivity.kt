package com.mobbile.paul.bcmobiletrader.ui.mainlogin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.module.ModuleActivity
import com.mobbile.paul.bcmobiletrader.util.CacheError
import com.mobbile.paul.bcmobiletrader.util.PermissionUtility
import com.mobbile.paul.bcmobiletrader.util.PreferenceKeys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.loginactivity.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel: LoginViewModel by viewModels()

    private lateinit var dataStore: DataStore<Preferences>

    lateinit var mLocationManager: LocationManager

    val RC_ENABLE_LOCATION = 1

    private var hasGps = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginactivity)
        dataStore = createDataStore(name = "settings")
        btnLogin.setOnClickListener(this)
        loginStateFlow()
    }

    //save Preference Data
    private suspend fun savePreferenceData(value: String) {
        val dataStoreKey = preferencesKey<String>(PreferenceKeys.APP_PREFERENCES)
        dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnLogin -> {
                callRequestPermission()
            }
        }
    }

    @SuppressLint("CommitPrefEdits")
    private fun loginStateFlow() {
        lifecycleScope.launchWhenStarted {
            viewModel.loginUiState.collect {
                it.let {
                    when (it) {

                        is LoginUiState.Loading -> {
                            progressBar.isVisible = true
                        }
                        is LoginUiState.Success -> {
                            progressBar.isVisible = false

                            if (it.data.statsus == 400) {
                                CacheError(applicationContext, it.data.msg!!).toast
                                return@collect
                            }

                            val mapPreferenceData = "${it.data.date}~|~${it.data.data!!.customerno}"
                            savePreferenceData(mapPreferenceData)
                            val intent = Intent(applicationContext, ModuleActivity::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_CLEAR_TOP.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                            intent.putExtra("setAllUserInfoData", it.data.data)
                            startActivity(intent)
                            finish()
                        }

                        is LoginUiState.Error -> {
                            progressBar.isVisible = false
                            CacheError(applicationContext, it.message).toast
                        }
                    }
                }
            }
        }
    }


    private fun callRequestPermission() {

        val permisonToRequest = PermissionUtility.requestPermision(this)

        if (permisonToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permisonToRequest.toTypedArray(), 0)
        } else {

            mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            hasGps = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

            if(!hasGps) {
                callGpsIntent()
            }else{
                val UserName: String = etUsername.text.toString()
                val password: String = etPassword.text.toString()
                val imei: String = "imie"
                viewModel.login(UserName, password, imei)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    println("permissionRequest  Granted")
                }
            }
        }
    }

    private fun callGpsIntent() {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivityForResult(intent, RC_ENABLE_LOCATION)
    }

}