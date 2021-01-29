package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import com.mobbile.paul.bcmobiletrader.domain.DomainResponseDto

sealed class ModuleUiState {
    object Success : ModuleUiState()
    data class Error(val message: String) : ModuleUiState()
    object Loading : ModuleUiState()
    object Empty : ModuleUiState()
}