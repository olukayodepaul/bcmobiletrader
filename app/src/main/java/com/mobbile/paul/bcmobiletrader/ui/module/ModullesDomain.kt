package com.mobbile.paul.bcmobiletrader.ui.module

import com.google.gson.annotations.SerializedName


data class ModulesResDto (
    @SerializedName("pk")
    var pk: Int? = null,
    @SerializedName("results")
    var results: List<ModulesListDto>
)

data class ModulesListDto (
    @SerializedName("pk")
    var pk: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("publisher")
    var publisher: String? = null,
    @SerializedName("featured_image")
    var featuredImage: String? = null,
    @SerializedName("rating")
    var rating: Int? = 0,
    @SerializedName("source_url")
    var sourceUrl: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("cooking_instructions")
    var cookingInstructions: String? = null,
    @SerializedName("ingredients")
    var ingredients: List<String>? = null,
    @SerializedName("date_added")
    var dateAdded: String? = null,
    @SerializedName("date_updated")
    var dateUpdated: String? = null
)