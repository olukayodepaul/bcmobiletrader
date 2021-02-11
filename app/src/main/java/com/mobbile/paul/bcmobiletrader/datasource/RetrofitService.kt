package com.mobbile.paul.bcmobiletrader.datasource


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
        @Query("custno") custno: String
    ): CustomerResDto

    @GET("/ba/api/products")
    suspend fun getProductListByCompany(): ProductResDto

}
