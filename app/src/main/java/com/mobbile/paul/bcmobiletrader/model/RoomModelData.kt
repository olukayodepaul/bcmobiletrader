package com.mobbile.paul.bcmobiletrader.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "modules")
data class modulesDao(
    @PrimaryKey(autoGenerate = false)
    var auto: Int = 0,
    var id: Int = 0
)