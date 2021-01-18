package com.mobbile.paul.bcmobiletrader.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AppDao {
    @Query("insert into modules (auto, id) values (:auto, :id) ")
    suspend fun insertInto(auto: Int, id: Int)
}