package com.mobbile.paul.bcmobiletrader.ui.salesentries

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
import kotlinx.android.synthetic.main.salesentry.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SalesEntryActivity: AppCompatActivity() {

    private val viewModel: SalesEntryViewModel by viewModels()
    private lateinit var nAdapter: SalesEntryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.salesentry)
        viewModel.fetchSalesEntryProduct()
        initAdapter()
        salesentryStateFlow()

        _sales_entry_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private fun initAdapter() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        _sales_entry_recycler_view.layoutManager = layoutManager
        _sales_entry_recycler_view.setHasFixedSize(true)
    }

    private fun salesentryStateFlow() {
        lifecycleScope.launchWhenCreated {
            viewModel.salesEntryUiStates.collect {
                it.let {
                    when (it) {
                        is SalesEntryUiState.Loading -> {
                            _sales_entry_progress_bar.isVisible = true
                        }
                        is SalesEntryUiState.Success -> {
                            _sales_entry_progress_bar.isVisible = false
                            nAdapter = SalesEntryAdapter(it.data, applicationContext)
                            nAdapter.notifyDataSetChanged()
                            _sales_entry_recycler_view.setItemViewCacheSize(it.data.size)
                            _sales_entry_recycler_view.adapter = nAdapter
                        }
                        is SalesEntryUiState.Error -> {
                            _sales_entry_progress_bar.isVisible = false
                            CacheError(applicationContext, it.message).toast
                        }
                    }
                }
            }
        }
    }
}