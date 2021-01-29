package com.mobbile.paul.bcmobiletrader.network



import com.mobbile.paul.bcmobiletrader.ui.customers.CustomerResDto
import com.mobbile.paul.bcmobiletrader.ui.mainloginfragment.UserLogin
import com.mobbile.paul.bcmobiletrader.ui.modulefragment.ModulesResDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService{

    @GET("ba/api/modules")
    suspend fun getModules(
        @Query("employeeid") employeeid: Int
    ): ModulesResDto

    @GET("ba/api/login")
    suspend fun login(
        @Header("username") username: String,
        @Query("password") password: String,
        @Query("ime1") ime1: String
    ): UserLogin

    @GET("ba/api/customers")
    suspend fun getCustomers(
        @Query("employeeid") employeeid: Int
    ): CustomerResDto

}
