package com.mobbile.paul.bcmobiletrader.ui.customers


sealed class CustomerUiState {
    object Loading : CustomerUiState()
    data class Error(val message: String) : CustomerUiState()
    data class Success(val data: CustomerResDto) : CustomerUiState()
    object Empty : CustomerUiState()
}