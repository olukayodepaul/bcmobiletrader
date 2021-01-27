package com.mobbile.paul.bcmobiletrader.network


import com.mobbile.paul.bcmobiletrader.domain.DomainResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService{

    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): DomainResponseDto

}