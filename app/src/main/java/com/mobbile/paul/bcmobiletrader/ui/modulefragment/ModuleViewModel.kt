package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositories
import kotlinx.coroutines.launch


class ModuleViewModel @ViewModelInject constructor(private val repository: ModuleRepositories): ViewModel() {

    /*fun uiState(): LiveData<DataState> = uiState
    private val uiState: MutableLiveData<DataState> = MutableLiveData()

    fun onRequestButtonClicked(token: String, page:Int, query:String){
        uiState.value = DataState.Loading
        viewModelScope.launch {
            try {
                val data = repository.search(token, page, query)
                uiState.value = DataState.Success(data)
            } catch (exception: Exception) {
                uiState.value = DataState.Error("Error message")
            }
        }
    }*/

    fun onRequestButtonClicked(token: String, page:Int, query:String) : LiveData<ModulesState>{
        val uiState = MutableLiveData<ModulesState>()
        uiState.value = ModulesState.Loading
        viewModelScope.launch {
            try {
                val data = repository.search(token, page, query)
                uiState.value = ModulesState.Success(data)
            } catch (exception: Exception) {
                uiState.value = ModulesState.Error(exception.localizedMessage)
            }
        }
        return uiState
    }

}
