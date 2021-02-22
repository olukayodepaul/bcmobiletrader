package com.mobbile.paul.bcmobiletrader.ui.customers

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.newcustomers.Newcustomers
import com.mobbile.paul.bcmobiletrader.ui.outletupdate.UpdateOutletActivity
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListActivity
import com.mobbile.paul.bcmobiletrader.ui.rejection.SkuRejectedActivity
import com.mobbile.paul.bcmobiletrader.util.CacheError
import com.mobbile.paul.bcmobiletrader.util.PermissionUtility
import com.mobbile.paul.bcmobiletrader.util.PreferenceKeys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.customersactivity.*
import kotlinx.android.synthetic.main.loginactivity.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first


@AndroidEntryPoint
class CustomersActivity : AppCompatActivity() {

    private val viewModel: CustomersViewModel by viewModels()

    private lateinit var nAdapter: CustomersAdapter

    private lateinit var dataStore: DataStore<Preferences>

    lateinit var mLocationManager: LocationManager

    private var hasGps = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customersactivity)
        dataStore = createDataStore(name = "settings")

        _customers_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        addCustomers.setOnClickListener {
            val intent = Intent(this, Newcustomers::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        callRequestPermission()
        initAdapter()
    }

    private suspend fun getPreferenceData(): String? {
        val dataStoreKey = preferencesKey<String>(PreferenceKeys.APP_PREFERENCES)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

    private fun initAdapter() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        tv_customers.layoutManager = layoutManager
        tv_customers.setHasFixedSize(true)
    }

    private fun customerStateFlow() {
        lifecycleScope.launchWhenCreated {
            viewModel.fetchUserCustomers(getPreferenceData()!!.split("~|~")[1]).collect {
                it.let {
                    when (it) {
                        is CustomerUiState.Loading -> {
                            progressCust.isVisible = true
                        }
                        is CustomerUiState.Success -> {

                            progressCust.isVisible = false

                            if(it.data.customer.isEmpty()){
                                CacheError(applicationContext,"Customers are not assign to you").toast
                                return@collect
                            }

                            nAdapter = CustomersAdapter(it.data.customer, applicationContext,::handleAdapterEvent)
                            nAdapter.notifyDataSetChanged()
                            tv_customers.setItemViewCacheSize(it.data.customer.size)
                            tv_customers.adapter = nAdapter

                        }
                        is CustomerUiState.Error -> {
                            progressCust.isVisible = false
                            CacheError(applicationContext, it.message).toast
                        }
                    }
                }
            }
        }
    }

    private  fun handleAdapterEvent(partItem: CustomersListDto, separators: String) {
        when(separators) {
            "_id_outletOpen"-> {
                val intent = Intent(applicationContext, ProductListActivity::class.java).apply {
                    putExtra("passingCustomerData", partItem)
                }
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
            "_id_close_outlet"-> {
                val intent = Intent(applicationContext, SkuRejectedActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
            "_gps_location"-> {
                val destination = "6.614690,3.512928"
                startGoogleMapIntent(applicationContext, destination, 'd', 't')
            }
            "_outlet_info_update"-> {
                val intent = Intent(applicationContext, UpdateOutletActivity::class.java).apply {
                    putExtra("passingCustomerData", partItem)
                }
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
            "sales_entry_details"-> {

            }
        }
    }

    private fun startGoogleMapIntent(ctx: Context, ads: String, mode: Char, avoid: Char): Any {
        val uri = Uri.parse("google.navigation:q=$ads&mode=$mode&avoid=$avoid")
        val mIntent = Intent(Intent.ACTION_VIEW, uri)
        mIntent.`package` = "com.google.android.apps.maps"
        return if (mIntent.resolveActivity(ctx.packageManager) != null) {
            ctx.startActivity(mIntent)
            true
        } else
            false
    }

    private fun callRequestPermission() {

        val permisonToRequest = PermissionUtility.requestPermission(this)

        if (permisonToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permisonToRequest.toTypedArray(), 0)
        } else {

            mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            hasGps = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

            if(!hasGps) {
                callGpsIntent()
            }else{
                customerStateFlow()
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

    override fun onRestart() {
        super.onRestart()

        mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        hasGps = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if(!hasGps) {
            callGpsIntent()
        }
    }

    private fun callGpsIntent() {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivityForResult(intent, 1)
    }
}