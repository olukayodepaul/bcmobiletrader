package com.mobbile.paul.bcmobiletrader.ui.customers

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.util.CacheError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.customersactivity.*
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class CustomersActivity : AppCompatActivity() {

    private val viewModel: CustomersViewModel by viewModels()
    private lateinit var nAdapter: CustomersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customersactivity)
        viewModel.fetchUserCustomers(2)
        initAdapter()
        customerStateFlow()

        _customers_toolbar.setNavigationOnClickListener {
           onBackPressed()
        }

    }

    private fun initAdapter() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        tv_customers.layoutManager = layoutManager
        tv_customers.setHasFixedSize(true)
    }

    private fun customerStateFlow() {
        lifecycleScope.launchWhenCreated {
            viewModel.customerUiStates.collect {
                it.let {
                    when (it) {
                        is CustomerUiState.Loading -> {
                            progressCust.isVisible = true
                        }
                        is CustomerUiState.Success -> {

                            progressCust.isVisible = false
                            if(it.data.customer.size==0){
                                CacheError(applicationContext,"Customers are not assign to you").toast
                                return@collect
                            }

                            nAdapter = CustomersAdapter(it.data.customer, applicationContext)
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


}