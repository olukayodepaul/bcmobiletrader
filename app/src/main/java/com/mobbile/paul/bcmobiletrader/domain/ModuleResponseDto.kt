package com.mobbile.paul.bcmobiletrader.domain

import com.google.gson.annotations.SerializedName

data class ModuleResponseDto (
    @SerializedName("pk")
    var pk: Int? = null,
    @SerializedName("results")
    var recipes: List<ModulesDto>
)