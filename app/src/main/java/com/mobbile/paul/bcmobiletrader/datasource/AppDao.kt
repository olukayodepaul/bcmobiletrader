package com.mobbile.paul.bcmobiletrader.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import com.mobbile.paul.bcmobiletrader.ui.salesentries.ItemsListCache

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoProduct(modules: List<ProductListEntity>)

    @Query("SELECT * FROM products WHERE groupid = :groupid")
    suspend fun selectFromProduct(groupid:String): List<ProductListEntity>

    @Query("UPDATE products SET checkitem=:checked WHERE item = :code ")
    suspend fun checkProduct(checked: Int, code: String)

    @Query("SELECT * FROM products WHERE checkitem = 2 AND groupid=:subdivision")
    suspend fun selectCheckProduct(subdivision: String): List<ProductListEntity>

    @Query("SELECT * FROM item")
    suspend fun selectAllItems(): List<ItemsListCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoItem(item: List<ItemsListCache>)

    @Query("SELECT * FROM item WHERE itemno = :itemno AND company = :company AND custpricegroup = :custpricegroup and unit = :unit limit 1")
    suspend fun selectSingleItems(itemno: String, company: String, custpricegroup: String, unit: String): ItemsListCache

    @Query("UPDATE products set amount = :amount, uofmeasure = :uofmeasure WHERE id = :id")
    suspend fun setPriceAndUnit(amount: Double, uofmeasure: String, id:Int )

    @Query("UPDATE products set shelf=:shelf, qty =:qty WHERE id = :id")
    suspend fun setShelfstockAndQty(shelf: Int, qty: Int, id:Int)

}
