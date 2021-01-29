package com.mobbile.paul.bcmobiletrader.ui.productlist.repository

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductResDto

class ProductListRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
) : ProductListRepository {
    override suspend fun getProductListByCompany(
        employeeid: Int,
        companyid: Int,
        subdivision: Int
    ): ProductResDto {
        return retrofitService.getProductListByCompany(employeeid, companyid, subdivision)
    }
}