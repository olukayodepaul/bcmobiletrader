package com.mobbile.paul.bcmobiletrader.repository.customers

import com.mobbile.paul.bcmobiletrader.domain.DomainResponseDto


data class ModuleStateEvent(
    val status: Int,
    val error: String,
    val body: DomainResponseDto? = null
)

