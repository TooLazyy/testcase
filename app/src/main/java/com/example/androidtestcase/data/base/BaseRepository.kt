package com.example.androidtestcase.data.base

import com.example.androidtestcase.data.error.ErrorHandler
import com.example.androidtestcase.data.utils.RequestResult

abstract class BaseRepository(
    private val errorHandler: ErrorHandler
) {

    internal fun <T> RequestResult<T>.handleError(): RequestResult<T> {
        return when (this) {
            is RequestResult.Success -> this
            is RequestResult.Error -> this.copy(error = errorHandler.handleError(this.error))
        }
    }
}