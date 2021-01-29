package com.mobbile.paul.bcmobiletrader.ui.modulefragment.repository


import com.mobbile.paul.bcmobiletrader.ui.modulefragment.ModulesResDto


interface ModuleRepository {
    suspend fun getModules(employeeid: Int): ModulesResDto
}