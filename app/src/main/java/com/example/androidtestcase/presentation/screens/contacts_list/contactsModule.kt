package com.example.androidtestcase.presentation.screens.contacts_list

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val contactsModule = module {

    single { ContactsPagerLoader(get()) }

    viewModel { ContactsListVM(get()) }
}