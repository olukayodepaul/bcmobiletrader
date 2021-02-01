package com.mobbile.paul.bcmobiletrader.network


import com.mobbile.paul.bcmobiletrader.ui.customers.CustomerResDto
import com.mobbile.paul.bcmobiletrader.ui.mainlogin.UserLoginRes
import com.mobbile.paul.bcmobiletrader.ui.module.ModulesResDto
import com.mobbile.paul.bcmobiletrader.ui.productlist.ProductResDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService{

    @GET("/ba/api/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("imei") imei: String
    ): UserLoginRes

    @GET("/ba/api/modules")
    suspend fun getModules(
        @Query("employeeid") employeeid: Int
    ): ModulesResDto

    @GET("/ba/api/customers")
    suspend fun getCustomers(
        @Query("employeeid") employeeid: Int
    ): CustomerResDto

    @GET("/ba/api/productlist")
    suspend fun getProductListByCompany(
        @Query("employeeid") employeeid: Int,
        @Query("companyid") companyid: Int,
        @Query("subdivision") subdivision: Int
    ): ProductResDto



}
