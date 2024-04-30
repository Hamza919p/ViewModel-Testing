package com.myproject.viewmodel_testing.ui.activities.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myproject.viewmodel_testing.data.models.ProductItem
import com.myproject.viewmodel_testing.ui.repository.ProductRepository
import com.myproject.viewmodel_testing.utils.NetworkResult
import kotlinx.coroutines.launch

class MainViewModel constructor(val productRepository: ProductRepository) : ViewModel() {

    private val _productsList = MutableLiveData<NetworkResult<List<ProductItem>>>()
    val productList: MutableLiveData<NetworkResult<List<ProductItem>>>
        get() = _productsList

    fun getProducts() {
        viewModelScope.launch {
           val result = productRepository.getProducts()
            _productsList.postValue(result)
        }
    }

}