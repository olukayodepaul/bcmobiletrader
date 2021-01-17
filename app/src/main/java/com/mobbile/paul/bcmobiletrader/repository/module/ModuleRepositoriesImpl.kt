package com.mobbile.paul.bcmobiletrader.repository.module

import com.mobbile.paul.bcmobiletrader.mappers.ModuleDtoMapper
import com.mobbile.paul.bcmobiletrader.model.ModuleModel
import com.mobbile.paul.bcmobiletrader.network.RetrofitService

class ModuleRepositoriesImpl(
    private val retrofitService: RetrofitService,
    private val moduleDtoMapper: ModuleDtoMapper
):
    ModuleRepositories
{
    override suspend fun search(token: String, page: Int, query: String): List<ModuleModel> {
        return moduleDtoMapper.toDomainList(retrofitService.search(token,page,query).recipes)
    }

    override suspend fun get(token: String, id: Int): ModuleModel {
        return moduleDtoMapper.mapToDomainModel(retrofitService.get(token, id))
    }
}