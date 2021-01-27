package com.mobbile.paul.bcmobiletrader.repository.module

import com.mobbile.paul.bcmobiletrader.domain.DomainResponseDto


interface ModuleRepositories {
    suspend fun search(token: String, page: Int, query: String): DomainResponseDto
}