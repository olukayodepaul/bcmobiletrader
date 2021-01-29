package com.mobbile.paul.bcmobiletrader.ui.mainloginfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.mobbile.paul.bcmobiletrader.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.loginfragment.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginFragment: Fragment(R.layout.loginfragment) {

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            ObservingLogin()
        }

    }

    private fun ObservingLogin() {
        viewModel.login("sdq","sxas","ascx")
        lifecycleScope.launchWhenStarted {
            viewModel.loginUiState.collect {
                it.let{
                    when(it) {
                        is LoginUiState.Loading->{
                            progressBar.visibility = View.VISIBLE
                            println("Mercy loading")
                        }
                        is LoginUiState.Success->{
                            println("Mercy ${it.data}")
                        }
                        is LoginUiState.Error->{
                            progressBar.visibility = View.INVISIBLE
                            println("Mercy $it.message")
                        }
                        is LoginUiState.Empty->{
                            println("Mercy empty")
                        }
                    }
                }
            }
        }
    }

}
