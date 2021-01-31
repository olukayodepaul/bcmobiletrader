package com.mobbile.paul.bcmobiletrader.ui.module


sealed class ModuleUiState {
    object Loading : ModuleUiState()
    data class Error(val message: String) : ModuleUiState()
    data class Success(val data: ModulesResDto) : ModuleUiState()
    object Empty : ModuleUiState()
}