package com.example.androidtestcase.presentation.screens.main

import com.example.androidtestcase.navigation.screens.ContactsListScreen
import com.example.androidtestcase.presentation.base.BaseVM

class MainVM : BaseVM<MainState>() {

    override val state: MainState = MainState()

    fun openInitialScreen() {
        router.newRootScreen(ContactsListScreen())
    }
}