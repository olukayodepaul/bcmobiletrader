package com.mobbile.paul.bcmobiletrader.ui.salesentries.repository


import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity

interface SalesEntryRepository{
    suspend fun getSelectProduct(subdivision: String): List<ProductListEntity>
}