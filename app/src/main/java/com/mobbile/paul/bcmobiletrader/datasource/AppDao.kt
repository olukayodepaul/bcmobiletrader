package com.mobbile.paul.bcmobiletrader.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoProduct(modules: List<ProductListEntity>)

    @Query("SELECT * FROM products")
    suspend fun selectFromProduct(): List<ProductListEntity>

    @Query("UPDATE products SET checked=:checked WHERE code = :code ")
    suspend fun checkProduct(checked: Int, code: String)

}
