package com.mobbile.paul.bcmobiletrader.ui.mainlogin



sealed class LoginUiState {
    object Loading : LoginUiState()
    data class Error(val message: String) : LoginUiState()
    data class Success(val data: UserLoginRes) : LoginUiState()
    object Empty : LoginUiState()
}
