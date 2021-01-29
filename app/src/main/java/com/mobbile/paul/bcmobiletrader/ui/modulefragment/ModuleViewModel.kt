package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ModuleViewModel @ViewModelInject constructor(val repository: ModuleRepositories): ViewModel() {


    //LiveData
    /*fun fetchUserModules(token: String, page:Int, query:String) : LiveData<ModulesState> {
        val uiState = MutableLiveData<ModulesState>()
        uiState.value = ModulesState.Loading
        viewModelScope.launch {
            try {
                val data = repository.search(token, page, query)
                uiState.value = ModulesState.Success(data)
            } catch (exception: Exception)  {
                uiState.value = ModulesState.Error("${exception.message}")
            }
        }
        return uiState
    }
    */

    //LiveData
    private val uiState: MutableLiveData<ModulesState> = MutableLiveData()
    fun uiState(): LiveData<ModulesState> = uiState

    fun fetchUserModules(token: String, page:Int, query:String) = viewModelScope.launch {
        uiState.value = ModulesState.Loading
        try {
            val data = repository.search(token, page, query)
            uiState.value = ModulesState.Success(data)
        } catch (exception: Exception)  {
            uiState.value = ModulesState.Error("${exception.message}")
        }
    }

    /*//State Flow
    private val _moduleUiState = MutableStateFlow<ModuleUiState>(ModuleUiState.Empty)
    val moduleUiState: StateFlow<ModuleUiState> = _moduleUiState

    fun fetchUserModule(token: String, page:Int, query:String)  = viewModelScope.launch {
        _moduleUiState.value = ModuleUiState.Loading
        try {
            val data = repository.search(token, page, query)
            _moduleUiState.value = ModuleUiState.Success
        } catch (exception: Exception)  {
            _moduleUiState.value = ModuleUiState.Error("Wrong credentials")
        }
    }*/




}
