package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mobbile.paul.bcmobiletrader.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.modulefragment.*

@AndroidEntryPoint
class ModuleFragment : Fragment(R.layout.modulefragment) {

    private val viewModel: ModuleViewModel by viewModels()

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
        onObserve()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    fun onObserve() {
        viewModel.onRequestButtonClicked("Token 9c8b06d329136da358c2d00e76946b0111ce2c48", 2, "chicken")
            .observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when(resource){
                    is ModulesState.Success ->{

                    }
                    is ModulesState.Loading ->{
                        println("ViewModelTest 2 $resource")
                    }
                    is ModulesState.Error ->{
                        println("ViewModelTest 3 $resource")
                    }
                }
            }
        })
    }


}