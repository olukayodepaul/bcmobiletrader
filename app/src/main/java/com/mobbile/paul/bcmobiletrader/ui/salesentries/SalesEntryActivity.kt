package com.mobbile.paul.bcmobiletrader.ui.salesentries

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import com.mobbile.paul.bcmobiletrader.util.CacheError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.sales_entry_adapter.view.*
import kotlinx.android.synthetic.main.salesentry.*
import kotlinx.coroutines.flow.collect
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class SalesEntryActivity: AppCompatActivity() {

    private val viewModel: SalesEntryViewModel by viewModels()

    private lateinit var nAdapter: SalesEntryAdapter

    var getGroupId:String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.salesentry)
        setSupportActionBar(_sales_entry_toolbar)
        getGroupId = intent.getStringExtra("groupid")!!
        viewModel.fetchSalesEntryProduct(getGroupId!!)
        initAdapter()
        salesentryStateFlow()

        _sales_entry_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.productmenu, menu)
        return true
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
                            nAdapter = SalesEntryAdapter(it.data, applicationContext,::adapterItemClicked)
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

    private fun adapterItemClicked(mItems: ProductListEntity, view: View?){

        var trasformBackRoom = 0
        var trasformShelfStock = 0
        var trasformOrder = 0

        if(view!!._backroom.text.toString().isNotEmpty()){
            trasformBackRoom = view._backroom.text.toString().toInt()
        }

        if(view._shelf.text.toString().isNotEmpty()){
            trasformShelfStock = view._shelf.text.toString().toInt()
        }

        if(view._order.text.toString().isNotEmpty()){
            trasformOrder = view._order.text.toString().toInt()
        }

        println("EPOKAHI ${trasformBackRoom}~${trasformShelfStock}~${trasformOrder} ${mItems.auto} ${getTime()}")
    }

    @SuppressLint("SimpleDateFormat")
    fun getTime(): String {
        return SimpleDateFormat("HH:mm:ss").format(Date())
    }
}