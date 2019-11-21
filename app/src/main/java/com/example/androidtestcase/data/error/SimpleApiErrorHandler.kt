package com.example.androidtestcase.data.error

import com.example.androidtestcase.data.error.errors.NoInternetApiError
import com.example.androidtestcase.data.error.errors.UnspecifiedApiError
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class SimpleApiErrorHandler : ErrorHandler {

    override fun handleError(throwable: Throwable?): BaseApiError {
        return when(throwable) {
            is UnknownHostException -> NoInternetApiError()
            is SocketTimeoutException -> NoInternetApiError()
            else -> UnspecifiedApiError()
        }
    }
}