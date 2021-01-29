package com.mobbile.paul.bcmobiletrader.ui.mainloginfragment


sealed class LoginUiState {
    object Loading : LoginUiState()
    data class Error(val message: String) : LoginUiState()
    data class Success(val data: UserLogin) : LoginUiState()
    object Empty : LoginUiState()
}
