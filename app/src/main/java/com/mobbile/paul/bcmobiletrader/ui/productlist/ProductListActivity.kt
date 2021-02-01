package com.mobbile.paul.bcmobiletrader.ui.productlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobbile.paul.bcmobiletrader.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productlist)
    }

}