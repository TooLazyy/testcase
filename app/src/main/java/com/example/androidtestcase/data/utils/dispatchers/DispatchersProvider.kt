package com.example.androidtestcase.data.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProvider {

    fun main(): CoroutineDispatcher

    fun default(): CoroutineDispatcher
}