package com.mobbile.paul.bcmobiletrader.ui.modulefragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.model.ModuleModel
import com.mobbile.paul.bcmobiletrader.repository.module.ModuleRepositories
import kotlinx.coroutines.launch


class ModuleViewModel @ViewModelInject constructor(private val repository: ModuleRepositories): ViewModel(){

    //passing Module Data to Fragment.......
    fun fetchMovieByQuery(token: String): LiveData<List<ModuleModel>> {
        val liveData = MutableLiveData<List<ModuleModel>>()
        viewModelScope.launch{
            val movies = repository.search(
                token = token,
                page = 1,
                query = "beef carrot potato onion"
            )
            liveData.postValue(movies)
        }
        return liveData
    }


}