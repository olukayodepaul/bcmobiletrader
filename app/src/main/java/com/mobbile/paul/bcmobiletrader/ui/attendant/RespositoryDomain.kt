package com.mobbile.paul.bcmobiletrader.ui.attendant


import com.google.gson.annotations.SerializedName


data class TodayTasks (
    @SerializedName("status")
    var status: Int? = 0,
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("time")
    var time: String? = null
)
