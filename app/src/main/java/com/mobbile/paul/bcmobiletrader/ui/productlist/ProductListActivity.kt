package com.mobbile.paul.bcmobiletrader.ui.productlist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.customers.CustomersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ProductListActivity: AppCompatActivity(){

    private val viewModel: ProductListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productlist)
        viewModel.fetchUserProducts(1,1)
        //modulesStateFlow()
    }

    /*private fun modulesStateFlow() {
        lifecycleScope.launchWhenCreated {
            viewModel.prodctsUiStates.collect {
                it.let {
                    println("SEEDATA ${it}")
                }
            }
        }
    }*/

}