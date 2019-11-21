package com.example.androidtestcase.data.error

interface ErrorHandler {

    fun handleError(throwable: Throwable?): BaseApiError
}