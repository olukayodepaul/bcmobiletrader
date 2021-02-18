package com.mobbile.paul.bcmobiletrader.ui.salesentries

import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity


sealed class SalesEntryUiState {
    object Loading : SalesEntryUiState()
    data class Error(val message: String) : SalesEntryUiState()
    data class Success(val data: List<ProductListEntity>) : SalesEntryUiState()
    object Empty : SalesEntryUiState()
}


sealed class ItemEntryUiState {
    object Loading : ItemEntryUiState()
    data class Error(val message: String) : ItemEntryUiState()
    data class Success(val data: ItemsListCache) : ItemEntryUiState()
    object Empty : ItemEntryUiState()
}