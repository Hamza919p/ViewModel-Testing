package com.myproject.viewmodel_testing.utils

sealed class NetworkResult<T>(val data: T? = null, val message: String?= null) {

    class Loading<T> : NetworkResult<T>()
    class Error<T>(message: String?) : NetworkResult<T>(message = message)
    class Data<T>(data: T?, message: String?) : NetworkResult<T>(data = data, message = message)

}