package com.mobbile.paul.bcmobiletrader.repository.module


import com.mobbile.paul.bcmobiletrader.model.NetworkMapperModelData

interface ModuleRepositories {
    suspend fun search(token: String, page: Int, query: String): List<NetworkMapperModelData>
    suspend fun get(token: String, id: Int): NetworkMapperModelData
    suspend fun insertIntoModule(auto:Int, id:Int)
}