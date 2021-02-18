package com.mobbile.paul.bcmobiletrader.ui.productlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.ui.productlist.repository.ProductListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class ProductListViewModel @ViewModelInject constructor(private val repository: ProductListRepository) :
    ViewModel() {

    private val _productsUiState = MutableStateFlow<ProductsUiState>(ProductsUiState.Empty)
    val prodctsUiStates get() = _productsUiState

    fun fetchUserProducts(subdivision: String) = viewModelScope.launch {
        _productsUiState.value = ProductsUiState.Loading
        try {

            val checkEmpty = repository.selectFromProduct(subdivision)

            if (checkEmpty.isEmpty()) {
                val data = repository.getProductListByCompany()
                repository.insertIntoProduct(data.products.map { it.toProductListEntity() })
                _productsUiState.value = ProductsUiState.Success(repository.selectFromProduct(subdivision))
                return@launch
            }

            _productsUiState.value = ProductsUiState.Success(repository.selectFromProduct(subdivision))

        } catch (e: Exception) {
            _productsUiState.value = ProductsUiState.Error(e.message.toString())
        }
    }

    //This is to check the selected item
    fun checkSelectProducts(checked: Int, code: String) = viewModelScope.launch {
        try {
            repository.checkProduct(checked, code)
        } catch (e: Exception) {
        }
    }


}