package com.mobbile.paul.bcmobiletrader.ui.module

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class ModulesResDto (
    @SerializedName("modules")
    var modules: List<ModulesListDto>
)

@Parcelize
data class ModulesListDto (
    @SerializedName("auto")
    var auto: Int? = null,
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("navid")
    var navid: Int? = 0,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("baemployee_id")
    var baemployee_id: Int? = 0
):Parcelable
