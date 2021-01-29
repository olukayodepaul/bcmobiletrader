package com.mobbile.paul.bcmobiletrader.ui.customers.repository

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.customers.CustomerResDto


class CustomerRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
) :
   CustomerRepository{
    override suspend fun getCustomers(employeeid: Int): CustomerResDto {
        return retrofitService.getCustomers(employeeid)
    }
}