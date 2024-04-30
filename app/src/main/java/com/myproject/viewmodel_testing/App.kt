package com.myproject.viewmodel_testing

import android.app.Application
import com.google.gson.Gson
import com.myproject.viewmodel_testing.network.ApiService
import com.myproject.viewmodel_testing.ui.repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var productsApi: ApiService
    lateinit var retrofit: Retrofit
    lateinit var productRepository: ProductRepository

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://fakestoreapi.com/")
            .build()

        productsApi = retrofit.create(ApiService::class.java)
        productRepository = ProductRepository(productsApi)
    }

}