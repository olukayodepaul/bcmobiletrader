package com.mobbile.paul.bcmobiletrader.repository.customers

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.domain.DomainResponseDto
import retrofit2.Response
import com.mobbile.paul.bcmobiletrader.mappers.ModuleDtoMapper
import com.mobbile.paul.bcmobiletrader.network.RetrofitService



class CustomerRepositorysImpl(
    private val retrofitService: RetrofitService,
    private val moduleDtoMapper: ModuleDtoMapper,
    private val appdoa: AppDao
) :
    CustomerRepositories {
    override suspend fun search(
        token: String,
        page: Int,
        query: String
    ): DomainResponseDto {
        return retrofitService.search(token, page, query)
    }
}