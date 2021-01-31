package com.mobbile.paul.bcmobiletrader.ui.module.repository


import com.mobbile.paul.bcmobiletrader.ui.module.ModulesResDto


interface ModuleRepository {
    suspend fun getModules(employeeid: Int): ModulesResDto
}