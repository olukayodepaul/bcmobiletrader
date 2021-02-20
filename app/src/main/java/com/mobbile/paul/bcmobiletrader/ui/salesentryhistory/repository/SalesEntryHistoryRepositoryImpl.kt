package com.mobbile.paul.bcmobiletrader.ui.salesentryhistory.repository


import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity


class SalesEntryHistoryRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
) : SalesEntryHistoryRepository{
    override suspend fun getEntries(groupname: String): List<ProductListEntity> {
        return appdoa.getEntries(groupname)
    }
}