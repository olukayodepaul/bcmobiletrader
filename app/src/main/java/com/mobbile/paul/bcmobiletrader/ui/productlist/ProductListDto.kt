package com.mobbile.paul.bcmobiletrader.ui.productlist

import com.google.gson.annotations.SerializedName

data class ProductResDto (
    @SerializedName("products")
    var products: List<ProductListDto>
)

data class ProductListDto (
    @SerializedName("auto")
    var auto: Int? = 0,
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("groupname")
    var groupname: String? = null,
    @SerializedName("item")
    var item: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("unit")
    var unit: String? = null,
    @SerializedName("groupid")
    var groupid: String? = null,
    @SerializedName("amount")
    var amount: Double? = null,
    @SerializedName("checkitem")
    var checkitem: Int? = 0,
    @SerializedName("qty")
    var qty: Int? = 0,
    @SerializedName("shelf")
    var shelf: Int? = 0,
    @SerializedName("uofmeasure")
    var uofmeasure: String? = null
)

