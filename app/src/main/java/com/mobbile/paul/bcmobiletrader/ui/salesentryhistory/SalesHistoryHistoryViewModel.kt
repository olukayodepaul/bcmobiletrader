package com.mobbile.paul.bcmobiletrader.ui.salesentryhistory

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.ui.salesentryhistory.repository.SalesEntryHistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SalesHistoryHistoryViewModel @ViewModelInject constructor(protected  val repository: SalesEntryHistoryRepository): ViewModel() {


    fun getAllSalesHistoryEntry(groupname: String): MutableStateFlow<SalesHistoryUiState> {
        val _itemUiState = MutableStateFlow<SalesHistoryUiState>(SalesHistoryUiState.Empty)
        viewModelScope.launch {
            _itemUiState.value = SalesHistoryUiState.Loading
            try {
                val data = repository.getEntries(groupname)
                _itemUiState.value = SalesHistoryUiState.Success(data)
            }catch (e: Exception){
                _itemUiState.value = SalesHistoryUiState.Error(e.localizedMessage)
            }
        }
        return _itemUiState
    }


}
