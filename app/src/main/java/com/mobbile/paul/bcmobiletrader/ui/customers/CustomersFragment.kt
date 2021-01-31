package com.mobbile.paul.bcmobiletrader.ui.customers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.mobbile.paul.bcmobiletrader.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.customersfragment.*

@AndroidEntryPoint
class CustomersFragment: Fragment(R.layout.customersfragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        toolbars.inflateMenu(R.menu.menu)
        /*toolbars.setNavigationOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_customersFragment_to_moduleFragment)
        }**/
    }
}