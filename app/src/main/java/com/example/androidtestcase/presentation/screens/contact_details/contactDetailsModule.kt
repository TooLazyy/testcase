package com.example.androidtestcase.presentation.screens.contact_details

import com.example.androidtestcase.domain.Contact
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val contactDetailsModule = module {

    viewModel { (contact: Contact) ->
        ContactDetailsVM(contact)
    }
}