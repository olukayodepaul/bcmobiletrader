package com.mobbile.paul.bcmobiletrader.ui.productlist.repository

import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductResDto


interface ProductListRepository {
    suspend fun getProductListByCompany(employeeid: Int, companyid: Int, subdivision: Int): ProductResDto
}