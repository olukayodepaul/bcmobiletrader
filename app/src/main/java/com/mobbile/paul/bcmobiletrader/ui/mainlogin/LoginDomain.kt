package com.mobbile.paul.bcmobiletrader.ui.mainlogin

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class UserLoginRes (
    @SerializedName("statsus")
    var statsus: Int = 0,
    @SerializedName("msg")
    var msg: String? = null,
    @SerializedName("data")
    var data:UserLogin? = null
)

@Parcelize
data class UserLogin (
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("customerno")
    var customerno:String? = null,
    @SerializedName("employee_code")
    var employee_code:String? = null,
    @SerializedName("company_id")
    var company_id:Int? = null,
    @SerializedName("subdivision_id")
    var subdivision_id:String? = null
): Parcelable

