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
    @ColumnInfo(name = "name")
    var name: String? = null,
    @ColumnInfo(name = "amount")
    var amount: String? = null,
    @ColumnInfo(name = "code")
    var code: String? = null,
    @ColumnInfo(name = "qty")
    var qty: Int? = 0,
    @ColumnInfo(name = "products")
    var products: String? = null,
    @ColumnInfo(name = "checked")
    var checked: Int? = 0,
    @ColumnInfo(name = "sheffstock")
    var sheffstock: Int? = 0,
    @ColumnInfo(name = "backroomstock")
    var backroomstock: Int? = 0,
    @ColumnInfo(name = "qtypurchase")
    var qtypurchase: Int? = 0
)


