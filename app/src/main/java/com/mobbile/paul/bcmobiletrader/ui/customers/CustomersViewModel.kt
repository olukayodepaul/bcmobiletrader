package com.mobbile.paul.bcmobiletrader.ui.customers

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.ui.customers.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CustomersViewModel @ViewModelInject constructor(private val repository: CustomerRepository): ViewModel() {

   /* private val _customerUiState = MutableStateFlow<CustomerUiState>(CustomerUiState.Empty)
    val customerUiStates get() = _customerUiState

    fun fetchUserCustomers(customerNo: String)  = viewModelScope.launch {
        _customerUiState.value = CustomerUiState.Loading
        try {
            val data = repository.getCustomers(customerNo)
            _customerUiState.value = CustomerUiState.Success(data)
        } catch (e: Exception) {
            _customerUiState.value = CustomerUiState.Error(e.message.toString())
        }
    }
*/


    fun fetchUserCustomers(customerNo: String) : MutableStateFlow<CustomerUiState> {

        val _customerUiState  = MutableStateFlow<CustomerUiState>(CustomerUiState.Empty)

        viewModelScope.launch{
            _customerUiState.value = CustomerUiState.Loading
            try {
                val data = repository.getCustomers(customerNo)
                _customerUiState.value = CustomerUiState.Success(data)
            } catch (e: Exception) {
                if(e.message.toString()=="timeout"){
                    _customerUiState.value = CustomerUiState.Error("Out of mobile data or bad network")
                }else if(e.message!!.contains("Unable to resolve host", true)){
                    _customerUiState.value = CustomerUiState.Error("Mobile data is off")
                }else if(e.message!!.contains("Failed to connect to", true)){
                    _customerUiState.value = CustomerUiState.Error("Mobile trader cloud is down")
                }else{
                    _customerUiState.value = CustomerUiState.Error(e.message.toString())
                }
            }
        }
        return _customerUiState
    }
}


