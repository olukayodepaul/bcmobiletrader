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
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("amount")
    var amount: String? = null,
    @SerializedName("code")
    var code: String? = null,
    @SerializedName("qty")
    var qty: Int? = 0,
    @SerializedName("products")
    var products: String? = null
)