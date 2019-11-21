package com.example.androidtestcase.presentation.screens.contacts_list

import com.example.androidtestcase.domain.Contact
import com.example.androidtestcase.presentation.base.BaseViewState
import com.example.androidtestcase.presentation.base.LoadingState

class ContactsListState : BaseViewState() {

    val contacts = mutableListOf<Contact>()
    val hasLoadingItem: Boolean
        get() = loading != LoadingState.None
    val hasItems: Boolean
        get() = contacts.isNotEmpty()

    fun updateContacts(list: List<Contact>) {
        contacts.addAll(list)
    }
}