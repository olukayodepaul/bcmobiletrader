package com.mobbile.paul.bcmobiletrader.ui.productlist.repository

import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductResDto


interface ProductListRepository {
    suspend fun getProductListByCompany(subdivisionid: Int, companyid: Int): ProductResDto
    suspend fun insertIntoProduct(modules: List<ProductListEntity>)
    suspend fun selectFromProduct(): List<ProductListEntity>
}
