package com.mobbile.paul.bcmobiletrader.ui.salesentryhistory.repository

import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity


interface SalesEntryHistoryRepository {
    suspend fun getEntries(groupname: String) :List<ProductListEntity>
}