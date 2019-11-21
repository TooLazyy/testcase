package com.example.androidtestcase.presentation.base

open class BaseViewState {

    var loading: LoadingState = LoadingState.None
}

sealed class LoadingState {

    object Loading : LoadingState()
    object Transparent : LoadingState()
    object None : LoadingState()
}