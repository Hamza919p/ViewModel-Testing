package com.myproject.viewmodel_testing.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("")
    suspend fun getProducts()

}