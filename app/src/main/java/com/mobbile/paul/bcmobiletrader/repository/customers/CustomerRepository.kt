package com.mobbile.paul.bcmobiletrader.repository.customers

import com.mobbile.paul.bcmobiletrader.domain.DomainResponseDto
import retrofit2.Response


interface CustomerRepository {
    suspend fun search(token: String, page: Int, query: String): DomainResponseDto
}