package com.mobbile.paul.bcmobiletrader.ui.salesentries

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbile.paul.bcmobiletrader.ui.salesentries.repository.SalesEntryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SalesEntryViewModel @ViewModelInject constructor(private val repository: SalesEntryRepository) :
    ViewModel() {

    private val _salesEntryUiState = MutableStateFlow<SalesEntryUiState>(SalesEntryUiState.Empty)
    val salesEntryUiStates get() = _salesEntryUiState

    fun fetchSalesEntryProduct(groupid: String, edcode: String) = viewModelScope.launch {

        val checkItems = repository.selectAllItemsFromLocalDb()

        if (checkItems.isEmpty()) {
            val data = repository.getItems(edcode)
            repository.inserttAllItemsIntoLocalDb(data.item.map { it.toItemsEntity() })
        }

        _salesEntryUiState.value = SalesEntryUiState.Loading

        try {
            _salesEntryUiState.value =
                SalesEntryUiState.Success(repository.getSelectProduct(groupid))
        } catch (e: Exception) {
            _salesEntryUiState.value = SalesEntryUiState.Error(e.message.toString())
        }
    }

    fun getPriceFromItems(itemno: String,company: String, custpricegroup: String, unit: String): MutableStateFlow<ItemEntryUiState> {
        val _itemUiState = MutableStateFlow<ItemEntryUiState>(ItemEntryUiState.Empty)
        viewModelScope.launch {
            _itemUiState.value = ItemEntryUiState.Loading
            try {
                val data = repository.selectSingleItems(itemno, company, custpricegroup, unit)
                _itemUiState.value = ItemEntryUiState.Success(data)
            }catch (e: Exception){
                _itemUiState.value = ItemEntryUiState.Error(e.localizedMessage)
            }
        }
        return _itemUiState
    }

    fun setPriceAndUnit(amount: Double, uofmeasure: String, id:Int) =   viewModelScope.launch{
        repository.setPriceAndUnit(amount, uofmeasure, id)
    }

    fun setShelfstockAndQty(shelf: Int, qty: Int, id:Int) = viewModelScope.launch {
        repository.setShelfstockAndQty(shelf, qty, id)
    }
}
