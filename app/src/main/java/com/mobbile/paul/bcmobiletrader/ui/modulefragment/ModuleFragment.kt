package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbile.paul.bcmobiletrader.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.modulefragment.*

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

        //coroutine Fragment and activity scope
        lifecycleScope.launchWhenCreated {
            onObserve()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    fun onObserve() {

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this.requireContext())
        tv_module.layoutManager = layoutManager
        tv_module!!.setHasFixedSize(true)

        viewModel.onRequestButtonClicked("Token 9c8b06d329136da358c2d00e76946b0111ce2c48", 2, "chicken")
            .observe(viewLifecycleOwner, Observer {
                it?.let { resource ->
                    when(resource) {
                        is ModulesState.Success ->{
                            println("ViewModelTest 1 $resource")
                            progressBar.visibility =View.INVISIBLE
                            nAdapter = ModuleAdapter(resource.data.results)
                            nAdapter.notifyDataSetChanged()
                            tv_module.setItemViewCacheSize(resource.data.results.size)
                            tv_module.adapter = nAdapter
                        }
                        is ModulesState.Loading ->{
                            println("ViewModelTest 2 $resource")
                            progressBar.visibility =View.VISIBLE
                        }
                        is ModulesState.Error ->{
                            progressBar.visibility =View.VISIBLE
                            println("ViewModelTest 3 $resource")
                        }
                    }
                }
            })
    }


}