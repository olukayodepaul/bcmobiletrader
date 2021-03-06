package com.mobbile.paul.bcmobiletrader.ui.productlist


sealed class ProductsUiState {
    object Loading : ProductsUiState()
    data class Error(val message: String) : ProductsUiState()
    data class Success(val data: List<ProductListEntity>) : ProductsUiState()
    object Empty : ProductsUiState()
}