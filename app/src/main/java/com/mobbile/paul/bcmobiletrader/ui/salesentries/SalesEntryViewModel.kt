package com.mobbile.paul.bcmobiletrader.ui.salesentries

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.ui.salesentries.repository.SalesEntryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SalesEntryViewModel @ViewModelInject constructor(private val repository: SalesEntryRepository):
    ViewModel() {

    private val _salesEntryUiState = MutableStateFlow<SalesEntryUiState>(SalesEntryUiState.Empty)
    val salesEntryUiStates get() = _salesEntryUiState

    fun fetchSalesEntryProduct() = viewModelScope.launch {
        _salesEntryUiState.value = SalesEntryUiState.Loading
        try {
            _salesEntryUiState.value = SalesEntryUiState.Success(repository.getSelectProduct())
        }catch (e: Exception) {
            _salesEntryUiState.value = SalesEntryUiState.Error(e.message.toString())
        }
    }

}