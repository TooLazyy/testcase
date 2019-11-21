package com.example.androidtestcase.presentation.screens.main

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    viewModel { MainVM() }
}