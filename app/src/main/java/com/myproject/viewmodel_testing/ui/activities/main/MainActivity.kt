package com.myproject.viewmodel_testing.ui.activities.main

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.myproject.viewmodel_testing.App
import com.myproject.viewmodel_testing.R
import com.myproject.viewmodel_testing.databinding.ActivityMainBinding
import com.myproject.viewmodel_testing.ui.ViewModelFactory
import com.myproject.viewmodel_testing.utils.NetworkResult

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val repository = (application as App).productRepository
        mainViewModel = ViewModelProvider(this, ViewModelFactory(repository))[MainViewModel::class.java]
        mainViewModel.getProducts()

        mainViewModel.productList.observe(this) { networkResult ->
            when(networkResult) {
                is NetworkResult.Loading -> {

                }
                is NetworkResult.Error -> {
                    Log.d("NetworkResultC", networkResult.message!! )

                }
                is NetworkResult.Data -> {


                }
            }
        }

        setContentView(binding.root)
    }
}