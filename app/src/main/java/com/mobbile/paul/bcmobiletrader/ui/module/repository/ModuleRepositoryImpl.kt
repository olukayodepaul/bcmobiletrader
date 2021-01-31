package com.mobbile.paul.bcmobiletrader.ui.module.repository

import com.mobbile.paul.bcmobiletrader.dao.AppDao
import com.mobbile.paul.bcmobiletrader.network.RetrofitService
import com.mobbile.paul.bcmobiletrader.ui.module.ModulesResDto


class ModuleRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val appdoa: AppDao
) :
    ModuleRepository {
    override suspend fun getModules(
        employeeid: Int
    ): ModulesResDto {
        return retrofitService.getModules(employeeid)
    }
}