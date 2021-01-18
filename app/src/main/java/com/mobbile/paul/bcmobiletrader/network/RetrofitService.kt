package com.mobbile.paul.bcmobiletrader.network

import com.mobbile.paul.bcmobiletrader.domain.DomainResponseDto
import com.mobbile.paul.bcmobiletrader.domain.DomainDataDto
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

    @GET("get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): DomainDataDto

}