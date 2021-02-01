package com.mobbile.paul.bcmobiletrader.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductListEntity

@Database(entities = [ProductListEntity::class],version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract val appdao: AppDao
    companion object {
        val DATABASE_NAME = "bc_mobile_trader_1_2_3"
    }
}