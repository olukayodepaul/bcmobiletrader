package com.mobbile.paul.bcmobiletrader.ui.productlist

import android.app.SearchManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.util.CacheError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.productlist.*
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class ProductListActivity : AppCompatActivity() {

    private val viewModel: ProductListViewModel by viewModels()
    private lateinit var nAdapter: ProductAdapter
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productlist)
        setSupportActionBar(_product_toolbar)
        viewModel.fetchUserProducts(1, 1)
        modulesStateFlow()
        initAdapter()

        _product_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

  /*  private fun initSearchView(menu: Menu) {
        applicationContext?.apply {
            val searchManager: SearchManager = getSystemService(SEARCH_SERVICE) as SearchManager
            searchView = menu.findItem(R.id.menu_search).actionView as SearchView
            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
            searchView.maxWidth = Integer.MAX_VALUE
            searchView.setIconifiedByDefault(true)
            searchView.isSubmitButtonEnabled = true
        }

        val searchPlate = searchView.findViewById(R.id.search_src_text) as EditText
        searchPlate.setOnEditorActionListener { v, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEARCH) {
                val searchQuery = v.text.toString()

            }
            true
        }
    }*/

    private fun resetUi() {
        tv_product.smoothScrollToPosition(0)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.productmenu, menu)
        /*initSearchView(menu!!)*/
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemView = item.itemId
        when (itemView) {
            R.id.menu_next -> {

            }
        }
        return false
    }

    private fun initAdapter() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        tv_product.layoutManager = layoutManager
        tv_product.setHasFixedSize(true)
    }

    private fun modulesStateFlow() {
        lifecycleScope.launchWhenCreated {
            viewModel.prodctsUiStates.collect {
                it.let {
                    when (it) {
                        is ProductsUiState.Loading -> {
                            productProgressBar.isVisible = true
                        }

                        is ProductsUiState.Success -> {
                            productProgressBar.isVisible = false
                            nAdapter = ProductAdapter(it.data, applicationContext)
                            nAdapter.notifyDataSetChanged()
                            tv_product.setItemViewCacheSize(it.data.size)
                            tv_product.adapter = nAdapter
                        }

                        is ProductsUiState.Error -> {
                            productProgressBar.isVisible = false
                            CacheError(applicationContext, it.message).toast
                        }
                    }
                }
            }
        }
    }


}

