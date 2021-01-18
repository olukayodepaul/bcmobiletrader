package com.mobbile.paul.bcmobiletrader.domain

import com.google.gson.annotations.SerializedName

data class DomainResponseDto (
    @SerializedName("pk")
    var pk: Int? = null,
    @SerializedName("results")
    var recipes: List<DomainDataDto>
)