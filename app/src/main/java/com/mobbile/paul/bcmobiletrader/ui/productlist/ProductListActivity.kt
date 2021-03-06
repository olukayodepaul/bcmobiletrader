package com.mobbile.paul.bcmobiletrader.ui.productlist


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.customers.CustomersListDto
import com.mobbile.paul.bcmobiletrader.ui.salesentries.SalesEntryActivity
import com.mobbile.paul.bcmobiletrader.util.CacheError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.productlist.*
import kotlinx.coroutines.flow.collect
import android.widget.SearchView


@AndroidEntryPoint
class ProductListActivity : AppCompatActivity() {

    private val viewModel: ProductListViewModel by viewModels()

    private lateinit var nAdapter: ProductAdapter

    private lateinit var getParceableData: CustomersListDto

    lateinit var dataCollection: List<ProductListEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productlist)
        setSupportActionBar(_product_toolbar)
        getParceableData = intent?.getParcelableExtra("passingCustomerData")!!
        viewModel.fetchUserProducts(getParceableData.subdivision!!)

        val searchViewItems:SearchView? = findViewById(R.id.search_view)

        modulesStateFlow()
        initAdapter()

        _product_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        image_back_icon.setOnClickListener {
            viewModel.fetchUserProducts(getParceableData.subdivision!!)
            _product_toolbar.isVisible = true
            _toolSearchView.isVisible = false
        }

        searchViewItems!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                nAdapter.filter.filter(newText)
                return false
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.productmenu, menu)
        /*val SearchItem  = menu!!.findItem(R.id.search_next)
        val searhView = SearchItem?.actionView as SearchView
        searhView.imeOptions = EditorInfo.IME_ACTION_DONE

        searhView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })*/
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemView = item.itemId
        when (itemView) {
            R.id.menu_next -> {
                val intent = Intent(applicationContext, SalesEntryActivity::class.java)
                intent.putExtra("groupid", getParceableData.subdivision!!)
                intent.putExtra("companies", getParceableData.busines!!)
                intent.putExtra("custpricegroup", getParceableData.custpricegroup!!)
                startActivity(intent)
            }
            R.id.search_next->{

                _product_toolbar.isVisible = false
                _toolSearchView.isVisible = true
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
                            dataCollection = it.data
                            nAdapter = ProductAdapter(::checkIfCheckboxIsCheked)
                            nAdapter.ProductAdapter(dataCollection as ArrayList<ProductListEntity>)
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

    private fun checkIfCheckboxIsCheked(code: String, ckeck: Int) {
        viewModel.checkSelectProducts(ckeck, code)
    }
}


