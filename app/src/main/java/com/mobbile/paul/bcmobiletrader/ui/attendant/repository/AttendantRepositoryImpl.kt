package com.mobbile.paul.bcmobiletrader.ui.attendant.repository


import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService


class AttendantRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
) :
   AttendantRepository{

}