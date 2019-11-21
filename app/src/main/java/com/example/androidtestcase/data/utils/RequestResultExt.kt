package com.example.androidtestcase.data.utils

inline fun <T> wrapResult(action: () -> T): RequestResult<T> {
    return try {
        RequestResult.Success(action())
    } catch (ex: Exception) {
        RequestResult.Error(ex)
    }
}