package com.mobbile.paul.bcmobiletrader.ui.productlist.repository

import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductResDto


interface ProductListRepository {
    suspend fun getProductListByCompany(): ProductResDto
    suspend fun insertIntoProduct(modules: List<ProductListEntity>)
    suspend fun selectFromProduct(groupid:String): List<ProductListEntity>
    suspend fun checkProduct(checked: Int, code: String)
}
