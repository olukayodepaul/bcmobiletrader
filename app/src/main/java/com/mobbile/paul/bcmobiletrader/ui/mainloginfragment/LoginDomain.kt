package com.mobbile.paul.bcmobiletrader.ui.mainloginfragment

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("ownersname")
    var ownersname: String? = null,
    @SerializedName("employeeid")
    var employeeid:String? = null
)
