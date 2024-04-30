package com.myproject.viewmodel_testing.ui.activities.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myproject.viewmodel_testing.ui.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel constructor(val productRepository: ProductRepository) : ViewModel() {


    fun getProducts() {
        viewModelScope.launch {
           val result = productRepository.getProducts()
        }
    }

}