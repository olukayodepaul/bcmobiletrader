package com.mobbile.paul.bcmobiletrader.ui.module

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.mainlogin.UserLogin
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModuleActivity : AppCompatActivity() {

    private val viewModel: ModuleViewModel by viewModels()
    var getAllUserInfoData: UserLogin? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modulefragment)
        getAllUserInfoData = intent.extras!!.getParcelable("setAllUserInfoData")
        println("Parcelable ${getAllUserInfoData!!.subdivision_id}")
    }


}
