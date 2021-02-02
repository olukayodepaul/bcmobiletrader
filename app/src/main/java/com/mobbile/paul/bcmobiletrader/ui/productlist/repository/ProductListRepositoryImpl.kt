package com.mobbile.paul.bcmobiletrader.ui.productlist.repository

import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductResDto


class ProductListRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
) : ProductListRepository {
    override suspend fun getProductListByCompany(
        subdivisionid: Int,
        companyid: Int
    ): ProductResDto {
        return retrofitService.getProductListByCompany(subdivisionid, companyid)
    }

    override suspend fun insertIntoProduct(modules: List<ProductListEntity>) {
        return appdoa.insertIntoProduct(modules)
    }

    override suspend fun selectFromProduct(): List<ProductListEntity> {
        return appdoa.selectFromProduct()
    }

}