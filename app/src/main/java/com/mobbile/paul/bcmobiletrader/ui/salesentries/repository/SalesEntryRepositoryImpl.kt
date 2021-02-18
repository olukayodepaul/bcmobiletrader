package com.mobbile.paul.bcmobiletrader.ui.salesentries.repository

import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import com.mobbile.paul.bcmobiletrader.ui.salesentries.ItemsEntryRes
import com.mobbile.paul.bcmobiletrader.ui.salesentries.ItemsListCache

class SalesEntryRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
): SalesEntryRepository{

    override suspend fun getSelectProduct(subdivision: String): List<ProductListEntity> {
        return appdoa.selectCheckProduct(subdivision)
    }

    override suspend fun getItems(repedcode: String): ItemsEntryRes {
        return retrofitService.getItems(repedcode)
    }

    override suspend fun selectAllItemsFromLocalDb(): List<ItemsListCache> {
        return appdoa.selectAllItems()
    }

    override suspend fun inserttAllItemsIntoLocalDb(local: List<ItemsListCache>) {
        return appdoa.insertIntoItem(local)
    }

    override suspend fun selectSingleItems(itemno: String,company: String, custpricegroup: String, unit: String): ItemsListCache {
        return appdoa.selectSingleItems(itemno, company, custpricegroup, unit)
    }

    override suspend fun setPriceAndUnit(amount: Double, uofmeasure: String, id: Int) {
        return appdoa.setPriceAndUnit(amount, uofmeasure, id)
    }

    override suspend fun setShelfstockAndQty(shelf: Int, qty: Int, id: Int) {
        appdoa.setShelfstockAndQty(shelf,qty,id)
    }

}