package com.mobbile.paul.bcmobiletrader.repository.module


import com.mobbile.paul.bcmobiletrader.model.ModuleModel

interface ModuleRepositories {
    suspend fun search(token: String, page: Int, query: String): List<ModuleModel>
    suspend fun get(token: String, id: Int): ModuleModel
    suspend fun insertIntoModule(auto:Int, id:Int)
}