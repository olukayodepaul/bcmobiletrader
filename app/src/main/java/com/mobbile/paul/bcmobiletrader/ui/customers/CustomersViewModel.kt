package com.mobbile.paul.bcmobiletrader.ui.customers

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.mobbile.paul.bcmobiletrader.repository.customers.CustomerRepository

class CustomersViewModel @ViewModelInject constructor(private val repository: CustomerRepository): ViewModel() {


}


