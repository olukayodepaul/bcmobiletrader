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


@AndroidEntryPoint
class ProductListActivity : AppCompatActivity() {

    private val viewModel: ProductListViewModel by viewModels()

    private lateinit var nAdapter: ProductAdapter

    private lateinit var getParceableData: CustomersListDto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productlist)
        setSupportActionBar(_product_toolbar)

        getParceableData = intent?.getParcelableExtra("passingCustomerData")!!

        viewModel.fetchUserProducts(getParceableData.subdivision!!)

        modulesStateFlow()
        initAdapter()

        _product_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.productmenu, menu)
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
                            nAdapter = ProductAdapter(it.data, applicationContext,::checkIfCheckboxIsCheked)
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

    private fun checkIfCheckboxIsCheked(code:String, ckeck:Int) {
        viewModel.checkSelectProducts(ckeck, code)
    }
}

