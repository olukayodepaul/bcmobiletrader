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

    fun fetchUserProducts(subdivisionid: Int, companyid: Int) = viewModelScope.launch {
        _productsUiState.value = ProductsUiState.Loading
        try {

            val data = repository.getProductListByCompany(subdivisionid, companyid)

            val mappers = repository.insertIntoProduct(data.products.map {
                it.toProductListEntity()
            })

            println("CHECKMAPPER $mappers")

        } catch (e: Exception) {
            _productsUiState.value = ProductsUiState.Error(e.message.toString())
        }
    }
}