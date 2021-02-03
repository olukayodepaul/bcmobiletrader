package com.mobbile.paul.bcmobiletrader.ui.mainlogin

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.ui.mainlogin.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class LoginViewModel @ViewModelInject constructor(private val repository: LoginRepository) :
    ViewModel() {

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    val loginUiState get() = _loginUiState

    fun login(username: String, password: String, imei: String) = viewModelScope.launch {
        _loginUiState.value = LoginUiState.Loading
        if (username.isEmpty() || password.isEmpty()) {
            _loginUiState.value = LoginUiState.Error("Please enter login credentials")
        } else {
            try {
                val data = repository.login(username, password, imei)
                _loginUiState.value = LoginUiState.Success(data)
            } catch (e: Throwable) {
                _loginUiState.value = LoginUiState.Error(e.message!!)
            }
        }
    }

    fun livePreference(userLogin: UserLoginRes) = viewModelScope.launch {
        repository.sharedPrefsEditor().apply()
        val editor = repository.sharedPrefsEditor()
        editor.clear()
        editor.putInt("_employee_code", userLogin.data!!.id!!)
        editor.putString("_transDate", userLogin.date)
    }

}
