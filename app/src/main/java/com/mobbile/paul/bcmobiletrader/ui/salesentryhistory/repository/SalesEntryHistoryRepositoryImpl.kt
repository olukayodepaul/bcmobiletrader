package com.mobbile.paul.bcmobiletrader.ui.salesentryhistory.repository

import android.content.SharedPreferences
import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService


class SalesEntryHistoryRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao,
    val sharedPreferences: SharedPreferences
) :
    SalesEntryHistoryRepository{

}