package com.mobbile.paul.bcmobiletrader.ui.module

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mobbile.paul.bcmobiletrader.ui.module.repository.ModuleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class ModuleViewModel @ViewModelInject constructor(private val repository: ModuleRepository): ViewModel() {

    private val _moduleUiState = MutableStateFlow<ModuleUiState>(ModuleUiState.Empty)
    val moduleUiState get() = _moduleUiState

    fun fetchUserModule(employeeid: Int)  = viewModelScope.launch {
        _moduleUiState.value = ModuleUiState.Loading
        try {
            val data = repository.getModules(employeeid)
            _moduleUiState.value = ModuleUiState.Success(data)
        } catch (e: Exception)  {
            _moduleUiState.value = ModuleUiState.Error(e.message.toString())
        }
    }

}
