package com.myproject.viewmodel_testing.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myproject.viewmodel_testing.ui.activities.main.MainViewModel
import com.myproject.viewmodel_testing.ui.repository.ProductRepository

class ViewModelFactory constructor(val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}