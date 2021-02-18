package com.mobbile.paul.bcmobiletrader.ui.productlist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductListEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "auto")
    var auto: Int? = 0,
    @ColumnInfo(name = "id")
    var id: Int? = 0,
    @ColumnInfo(name = "groupname")
    var groupname: String? = null,
    @ColumnInfo(name = "item")
    var item: String? = null,
    @ColumnInfo(name = "name")
    var name: String? = null,
    @ColumnInfo(name = "unit")
    var unit: String? = null,
    @ColumnInfo(name = "groupid")
    var groupid: String? = null,
    @ColumnInfo(name = "amount")
    var amount: Double? = null,
    @ColumnInfo(name = "checkitem")
    var checkitem: Int? = null,
    @ColumnInfo(name = "qty")
    var qty: Int? = 0,
    @ColumnInfo(name = "shelf")
    var shelf: Int? = 0,
    @ColumnInfo(name = "uofmeasure")
    var uofmeasure: String? = null
)


