package com.example.androidtestcase.presentation.screens.contact_details

import com.example.androidtestcase.domain.Contact
import com.example.androidtestcase.presentation.base.BaseVM

class ContactDetailsVM(contact: Contact) : BaseVM<ContactDetailsState>() {

    override val state: ContactDetailsState = ContactDetailsState(contact)

    fun loadContact() {
        render(state)
    }
}