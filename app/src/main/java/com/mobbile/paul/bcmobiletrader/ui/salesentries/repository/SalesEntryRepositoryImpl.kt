package com.mobbile.paul.bcmobiletrader.ui.salesentries.repository

import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity

class SalesEntryRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
): SalesEntryRepository{
    override suspend fun getSelectProduct(): List<ProductListEntity> {
        return appdoa.selectCheckProduct()
    }
}