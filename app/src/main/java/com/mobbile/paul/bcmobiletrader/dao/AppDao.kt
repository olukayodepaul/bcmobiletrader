package com.mobbile.paul.bcmobiletrader.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoProduct(modules: List<ProductListEntity>)

}

