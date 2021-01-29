package com.mobbile.paul.bcmobiletrader.ui.productlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.mobbile.paul.bcmobiletrader.ui.productlist.repository.ProductListRepository


class ProductListViewModel @ViewModelInject constructor(private val  repository: ProductListRepository) : ViewModel(){


}