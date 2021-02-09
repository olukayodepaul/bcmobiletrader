package com.mobbile.paul.bcmobiletrader.ui.customers

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class CustomerResDto (
    @SerializedName("customer")
    var customer: List<CustomersListDto>
)


@Parcelize
data class CustomersListDto (
    @SerializedName("auto")
    var auto: Int = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("custno")
    var custno: String? = null,
    @SerializedName("custname")
    var custname: String? = null,
    @SerializedName("custaddress")
    var custaddress: String? = null,
    @SerializedName("region")
    var region: String? = null,
    @SerializedName("primarycontact")
    var primarycontact: String? = null,
    @SerializedName("busines")
    var busines: String? = null,
    @SerializedName("salesrepcode")
    var salesrepcode: String? = null,
    @SerializedName("blocked")
    var blocked: String? = null,
    @SerializedName("lat")
    var lat: String? = null,
    @SerializedName("lng")
    var lng: String? = null,
    @SerializedName("subdivision")
    var subdivision: String? = null,
    @SerializedName("baemployee_id")
    var baemployee_id: String? = null
): Parcelable

