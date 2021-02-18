package com.mobbile.paul.bcmobiletrader.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity
import com.mobbile.paul.bcmobiletrader.ui.salesentries.ItemsListCache

@Database(entities = arrayOf(ProductListEntity::class, ItemsListCache::class),version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract val appdao: AppDao
    companion object {
        val DATABASE_NAME = "bc_mobile_trader_1_2_3"
    }
}