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

    @Query("SELECT * FROM products WHERE groupid=:groupid")
    suspend fun selectFromProduct(groupid:String): List<ProductListEntity>

    @Query("UPDATE products SET checkitem=:checked WHERE item = :code ")
    suspend fun checkProduct(checked: Int, code: String)

    @Query("SELECT * FROM products WHERE checkitem = 2 AND groupid=:subdivision")
    suspend fun selectCheckProduct(subdivision: String): List<ProductListEntity>

}
