package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import com.mobbile.paul.bcmobiletrader.domain.DomainResponseDto

sealed class ModulesState {
    object Loading : ModulesState()
    data class Success(val data: DomainResponseDto) : ModulesState()
    data class Error(val message: String) : ModulesState()

}
