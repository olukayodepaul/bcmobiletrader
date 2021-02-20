package com.mobbile.paul.bcmobiletrader.ui.customers.repository


import com.mobbile.paul.bcmobiletrader.datasource.AppDao
import com.mobbile.paul.bcmobiletrader.datasource.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.customers.CustomerResDto


class CustomerRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
) :
   CustomerRepository{
    override suspend fun getCustomers(custno: String): CustomerResDto {
        return retrofitService.getCustomers(custno)
    }


}