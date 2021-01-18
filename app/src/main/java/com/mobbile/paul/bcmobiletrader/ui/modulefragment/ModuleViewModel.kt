package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.model.ModuleModel
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositories
import kotlinx.coroutines.launch


class ModuleViewModel @ViewModelInject constructor(private val repository: ModuleRepositories): ViewModel() {

    fun fetchAllModules(token: String, page:Int, query:String): LiveData<List<ModuleModel>> {
        val liveData = MutableLiveData<List<ModuleModel>>()
        viewModelScope.launch {
            val fetchAllModules = repository.search(
                token, page, query
            )
            liveData.postValue(fetchAllModules)
        }

        viewModelScope.launch {
            repository.insertIntoModule(
                1,10
            )
        }
        return liveData
    }


}