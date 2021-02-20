package com.mobbile.paul.bcmobiletrader.ui.salesentryhistory

import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity

sealed class SalesHistoryUiState {
    object Loading : SalesHistoryUiState()
    data class Error(val message: String) : SalesHistoryUiState()
    data class Success(val data: List<ProductListEntity>) : SalesHistoryUiState()
    object Empty : SalesHistoryUiState()
}
