package com.mobbile.paul.bcmobiletrader.ui.customers.repository

import com.mobbile.paul.bcmobiletrader.ui.customers.CustomerResDto


interface CustomerRepository {
    suspend fun getCustomers(custno: String): CustomerResDto
}