package com.example.androidtestcase.di

import com.example.androidtestcase.data.error.ErrorHandler
import com.example.androidtestcase.data.error.SimpleApiErrorHandler
import com.example.androidtestcase.data.utils.dispatchers.DispatchersProvider
import com.example.androidtestcase.data.utils.dispatchers.DispatchersProviderImpl
import org.koin.dsl.module

val dataModule = module {

    single<DispatchersProvider> { DispatchersProviderImpl() }

    single<ErrorHandler> { SimpleApiErrorHandler() }
}