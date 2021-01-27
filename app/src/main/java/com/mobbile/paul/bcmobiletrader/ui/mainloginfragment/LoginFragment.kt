package com.mobbile.paul.bcmobiletrader.ui.mainloginfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.mobbile.paul.bcmobiletrader.R
import kotlinx.android.synthetic.main.loginfragment.*

class LoginFragment: Fragment(R.layout.loginfragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_loginFragment_to_moduleFragment)
        }
    }
}