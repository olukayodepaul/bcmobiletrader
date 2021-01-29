package com.mobbile.paul.bcmobiletrader.ui.mainloginfragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.ui.mainloginfragment.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class LoginViewModel @ViewModelInject constructor(private val repository: LoginRepository): ViewModel() {


    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    val loginUiState get() = _loginUiState

    fun login(username: String, password: String, ime1: String) = viewModelScope.launch{
        println("Mercy empty")
        _loginUiState.value = LoginUiState.Loading
        if(username.isEmpty() && password.isEmpty()) {
            _loginUiState.value= LoginUiState.Error("Please enter login credential")
        } else {
            try {
                val data = repository.login(username, password, ime1)
                _loginUiState.value = LoginUiState.Success(data)
            }catch (e: Exception) {
                _loginUiState.value= LoginUiState.Error(e.message.toString())
            }
        }
    }

}
