package com.example.androidtestcase.data.utils

sealed class RequestResult<T> {

    data class Success<T> (val data: T) : RequestResult<T>()
    data class Error<T> (val error: Throwable) : RequestResult<T>()
}