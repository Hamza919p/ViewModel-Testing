package com.myproject.viewmodel_testing.network

import com.myproject.viewmodel_testing.data.models.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/products")
    suspend fun getProducts() : Response<List<ProductItem>>

}