package com.myproject.viewmodel_testing.ui.repository

import com.myproject.viewmodel_testing.data.models.ProductItem
import com.myproject.viewmodel_testing.network.ApiService
import com.myproject.viewmodel_testing.utils.NetworkResult

class ProductRepository constructor(private val apiService: ApiService) {

    suspend fun getProducts() : NetworkResult<List<ProductItem>> {
        val response = apiService.getProducts()
        return try {
            if(response.isSuccessful) {
                NetworkResult.Data(response.body(), "Success")
            } else {
                NetworkResult.Error(message = "Something went wrong")
            }
        } catch (e: Exception) {
                NetworkResult.Error(message = e.message)
        }
    }

}