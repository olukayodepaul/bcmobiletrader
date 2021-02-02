package com.mobbile.paul.bcmobiletrader.ui.salesentries.repository


import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity

interface SalesEntryRepository{
    suspend fun getSelectProduct(): List<ProductListEntity>
}