package com.mobbile.paul.bcmobiletrader.ui.productlist

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class ProductListEntity (
    @PrimaryKey(autoGenerate = false)
    var auto: Int? = 0,
    var id: Int? = 0,
    var name: String? = null,
    var amount: String? = null,
    var code: String? = null,
    var qty: Int? = 0,
    var products: String? = null,
    var checked: Int? = 0,
    var sheffstock: Int? = 0,
    var backroomstock: Int? = 0,
    var qtypurchase: Int? = 0
)


