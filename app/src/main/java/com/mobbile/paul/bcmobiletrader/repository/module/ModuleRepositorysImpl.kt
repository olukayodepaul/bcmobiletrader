package com.mobbile.paul.bcmobiletrader.repository.module

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.mappers.ModuleDtoMapper
import com.mobbile.paul.bcmobiletrader.model.NetworkMapperModelData
import com.mobbile.paul.bcmobiletrader.network.RetrofitService

class ModuleRepositorysImpl(
    private val retrofitService: RetrofitService,
    private val moduleDtoMapper: ModuleDtoMapper,
    private val appdoa: AppDao

) :
    ModuleRepositories {
    override suspend fun search(
        token: String,
        page: Int,
        query: String
    ): List<NetworkMapperModelData> {
        return moduleDtoMapper.toDomainList(retrofitService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): NetworkMapperModelData {
        return moduleDtoMapper.mapToDomainModel(retrofitService.get(token, id))
    }

    override suspend fun insertIntoModule(auto: Int, id: Int) {
        appdoa.insertInto(auto, id)
    }
}