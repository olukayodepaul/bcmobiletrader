package com.mobbile.paul.bcmobiletrader.ui.modulefragment.repository

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.mappers.ModuleDtoMapper
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.modulefragment.ModulesResDto


class ModuleRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val moduleDtoMapper: ModuleDtoMapper,
    private val appdoa: AppDao
) :
    ModuleRepository {
    override suspend fun getModules(
        employeeid: Int
    ): ModulesResDto {
        return retrofitService.getModules(employeeid)
    }
}