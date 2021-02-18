package com.mobbile.paul.bcmobiletrader.ui.salesentries

import com.google.gson.annotations.SerializedName


data class ItemsEntryRes (
    @SerializedName("item")
    var item: List<ItemsListDto>
)

data class ItemsListDto (
    @SerializedName("auto")
    var auto: Int? = null,
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("unit")
    var unit: String? = null,
    @SerializedName("itemno")
    var itemno: String? = null,
    @SerializedName("price")
    var price: String? = null,
    @SerializedName("company")
    var company: String? = null,
    @SerializedName("custpricegroup")
    var custpricegroup: String? = null
)