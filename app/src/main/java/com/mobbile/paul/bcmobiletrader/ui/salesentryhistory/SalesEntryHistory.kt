package com.mobbile.paul.bcmobiletrader.ui.salesentryhistory


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_sales_entry_history.*
import kotlinx.coroutines.flow.collect
import java.text.NumberFormat


@AndroidEntryPoint
class SalesEntryHistory : AppCompatActivity() {

    private val viewModel: SalesHistoryHistoryViewModel by viewModels()

    private lateinit var nAdapter: SalesHistoryAdaptet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales_entry_history)
        setSupportActionBar(_entryhistory_toolbar)

        _entryhistory_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        initAdapter()

        //working on this part
        listeningToIncomingData("250 GALLO")
    }

    @SuppressLint("SetTextI18n")
    private fun listeningToIncomingData(groupname: String) {
        lifecycleScope.launchWhenStarted {
            viewModel.getAllSalesHistoryEntry(groupname).collect {
                it.let {
                    when(it){
                        is SalesHistoryUiState.Loading->{
                            _history_progress_bar.isVisible = true
                        }

                        is SalesHistoryUiState.Success->{
                            _history_progress_bar.isVisible = false
                            nAdapter = SalesHistoryAdaptet(it.data, applicationContext)
                            nAdapter.notifyDataSetChanged()

                            val total = it.data.map {sums-> sums.amount!!.toDouble()*sums.qty!!.toDouble()}.sum()
                            _tv_total.text = "Total: N${NumberFormat.getInstance().format(total)}"

                            _history_recyclerView.setItemViewCacheSize(it.data.size)
                            _history_recyclerView.adapter = nAdapter
                        }

                        is SalesHistoryUiState.Error->{
                            _history_progress_bar.isVisible = false
                        }
                    }
                }
            }
        }
    }

    private fun initAdapter() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        _history_recyclerView.layoutManager = layoutManager
        _history_recyclerView.setHasFixedSize(true)
    }

}