package com.mobbile.paul.bcmobiletrader.ui.module

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import com.mobbile.paul.bcmobiletrader.ui.mainlogin.UserLogin
import com.mobbile.paul.bcmobiletrader.util.CacheError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.customersactivity.*
import kotlinx.android.synthetic.main.moduleactivity.*
import kotlinx.android.synthetic.main.network_error.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ModuleActivity : AppCompatActivity() {

    private val viewModel: ModuleViewModel by viewModels()

    var getAllUserInfoData: UserLogin? = null

    private lateinit var nAdapter: ModuleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.moduleactivity)
        getAllUserInfoData = intent.extras!!.getParcelable("setAllUserInfoData")!!
        viewModel.fetchUserModule(getAllUserInfoData!!.id!!)

        click_refresh.setOnClickListener {
            viewModel.fetchUserModule(getAllUserInfoData!!.id!!)
        }

        modulesStateFlow()
        initAdapter()
    }

    private fun initAdapter() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        tv_module.layoutManager = layoutManager
        tv_module.setHasFixedSize(true)
    }

    private fun modulesStateFlow() {
        lifecycleScope.launchWhenCreated {
            viewModel.moduleUiState.collect {
                it.let {
                    when (it) {
                        is ModuleUiState.Loading -> {
                            progressBarID.isVisible = true
                        }
                        is ModuleUiState.Success -> {
                            progressBarID.isVisible = false
                            modules_overlay_view.isVisible = false
                            tv_module.isVisible = true
                            nAdapter = ModuleAdapter(it.data.modules, applicationContext)
                            nAdapter.notifyDataSetChanged()
                            tv_module.setItemViewCacheSize(it.data.modules.size)
                            tv_module.adapter = nAdapter
                        }
                        is ModuleUiState.Error -> {
                            progressBarID.isVisible = false
                            modules_overlay_view.isVisible = true
                            tv_module.isVisible = false
                            tv_network.text = it.message
                        }
                    }
                }
            }
        }
    }
}
