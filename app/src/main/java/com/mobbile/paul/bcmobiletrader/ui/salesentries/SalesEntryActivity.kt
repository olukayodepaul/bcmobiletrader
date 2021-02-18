package com.mobbile.paul.bcmobiletrader.ui.salesentries

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
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
class SalesEntryActivity : AppCompatActivity() {

    private val viewModel: SalesEntryViewModel by viewModels()

    private lateinit var nAdapter: SalesEntryAdapter

    var getGroupId: String? = ""
    var getCompany: String? = ""
    var getCustPriceGroup: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.salesentry)
        setSupportActionBar(_sales_entry_toolbar)

        getGroupId = intent.getStringExtra("groupid")!!
        getCompany = intent.getStringExtra("companies")!!
        getCustPriceGroup = intent.getStringExtra("custpricegroup")!!

        viewModel.fetchSalesEntryProduct(getGroupId!!, "CPE005551")
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
                            nAdapter =
                                SalesEntryAdapter(it.data, applicationContext, ::adapterItemClicked)
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

    private fun adapterItemClicked(mItems: ProductListEntity, view: View?, specifier: String) {

        //this allow you to test which one is clicked..........
        var trasformShelf = 0
        var trasformOrder = 0
        var trasformItem = ""


        if (view!!._shelf.text.toString().isNotEmpty()) {
            trasformShelf = view._shelf.text.toString().toInt()
        }

        if (view._order.text.toString().isNotEmpty()) {
            trasformOrder = view._order.text.toString().toInt()
        }

        if (specifier.equals("_items")) {
            lifecycleScope.launchWhenCreated {
                val getItemSelected = view._items.selectedItem.toString()
                viewModel.getPriceFromItems(mItems.item!!, getCompany!!, getCustPriceGroup!!, getItemSelected).collect {
                    it.let {
                        when (it) {
                            is ItemEntryUiState.Loading -> {
                            }
                            is ItemEntryUiState.Success -> {
                                if (getItemSelected != "SELECT") {
                                    viewModel.setPriceAndUnit(it.data.price!!.toDouble(), getItemSelected, mItems.id!!)
                                }
                            }
                            is ItemEntryUiState.Error -> {
                                if (getItemSelected != "SELECT") {
                                    view._items.setSelection(0)
                                    CacheError(
                                        applicationContext,
                                        "No ${getItemSelected} Available for this sku"
                                    ).toast
                                }
                            }
                        }
                    }
                }
            }
        }
        /*println("EPOKAHI ${trasformBackRoom}~${trasformShelfStock}~${trasformOrder} ${mItems.auto} ${getTime()}")*/
    }

    @SuppressLint("SimpleDateFormat")
    fun getTime(): String {
        return SimpleDateFormat("HH:mm:ss").format(Date())
    }

}