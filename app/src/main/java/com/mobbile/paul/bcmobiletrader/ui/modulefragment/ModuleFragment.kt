package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mobbile.paul.bcmobiletrader.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.modulefragment.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ModuleFragment : Fragment(R.layout.modulefragment) {

    private val viewModel: ModuleViewModel by viewModels()

    private lateinit var nAdapter: ModuleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.inflateMenu(R.menu.menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.searches -> {
                    true
                }
                else -> false
            }
        }
        ObservingModuleData()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    private fun ObservingModuleData() {
        viewModel.fetchUserModule(1)
        lifecycleScope.launchWhenStarted {
            viewModel.moduleUiState.collect {
                it.let {
                    when (it) {
                        is ModuleUiState.Success -> {
                            progressBar.visibility = View.INVISIBLE
                           // nAdapter = ModuleAdapter(it.data.)
                           // nAdapter.notifyDataSetChanged()
                           // tv_module.setItemViewCacheSize(it.data.results.size)
                           // tv_module.adapter = nAdapter
                        }
                        is ModuleUiState.Loading -> {
                            progressBar.visibility = View.VISIBLE
                        }
                        is ModuleUiState.Error -> {
                            progressBar.visibility = View.INVISIBLE
                        }
                    }
                }
            }
        }
    }
}
