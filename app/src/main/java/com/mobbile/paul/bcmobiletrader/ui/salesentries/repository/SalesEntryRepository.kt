package com.mobbile.paul.bcmobiletrader.ui.salesentries.repository


import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import com.mobbile.paul.bcmobiletrader.ui.salesentries.ItemsEntryRes
import com.mobbile.paul.bcmobiletrader.ui.salesentries.ItemsListCache

interface SalesEntryRepository {
    suspend fun getSelectProduct(subdivision: String): List<ProductListEntity>
    suspend fun getItems(repedcode: String): ItemsEntryRes
    suspend fun selectAllItemsFromLocalDb(): List<ItemsListCache>
    suspend fun inserttAllItemsIntoLocalDb(local: List<ItemsListCache>)
    suspend fun selectSingleItems(itemno: String, company: String, custpricegroup: String, unit: String): ItemsListCache
    suspend fun setPriceAndUnit(amount: Double, uofmeasure: String, id:Int)
    suspend fun setShelfstockAndQty(shelf: Int, qty: Int, id:Int)
}