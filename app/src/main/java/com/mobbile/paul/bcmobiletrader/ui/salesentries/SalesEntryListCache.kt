package com.mobbile.paul.bcmobiletrader.ui.salesentries

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "item")
data class ItemsListCache (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "auto")
    var auto: Int? = 0,
    @ColumnInfo(name = "id")
    var id: Int? = 0,
    @ColumnInfo(name = "unit")
    var unit: String? = null,
    @ColumnInfo(name = "itemno")
    var itemno: String? = null,
    @ColumnInfo(name = "price")
    var price: String? = null,
    @ColumnInfo(name = "company")
    var company: String? = null,
    @ColumnInfo(name = "custpricegroup")
    var custpricegroup: String? = null
)