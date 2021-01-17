package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.mobbile.paul.bcmobiletrader.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.modulefragment.*
import androidx.lifecycle.Observer

@AndroidEntryPoint
class ModuleFragment : Fragment(R.layout.modulefragment) {

    private val viewModel: ModuleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        toolbar.inflateMenu(R.menu.menu)
        toolbar.setNavigationOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.sentToSecondFragment)
        }

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.searches -> {
                    true
                }
                else -> false
            }
        }

        viewModel.fetchMovieByQuery(
            "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
        ).observe(viewLifecycleOwner, Observer {
            println("LINES $it")
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

}