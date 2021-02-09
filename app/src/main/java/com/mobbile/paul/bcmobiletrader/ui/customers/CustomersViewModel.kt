package com.mobbile.paul.bcmobiletrader.ui.customers

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.ui.customers.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CustomersViewModel @ViewModelInject constructor(private val repository: CustomerRepository): ViewModel() {

    private val _customerUiState = MutableStateFlow<CustomerUiState>(CustomerUiState.Empty)
    val customerUiStates get() = _customerUiState

    fun fetchUserCustomers()  = viewModelScope.launch {
        _customerUiState.value = CustomerUiState.Loading
        try {
            println("SALESCODE 2 ${repository.sharedPreferences().getString("customerNumber","")!!}")
            val data = repository.getCustomers("CPE005551")
            _customerUiState.value = CustomerUiState.Success(data)
        } catch (e: Exception) {
            _customerUiState.value = CustomerUiState.Error(e.message.toString())
        }
    }
}


