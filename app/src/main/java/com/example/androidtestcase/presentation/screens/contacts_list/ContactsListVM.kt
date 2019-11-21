package com.example.androidtestcase.presentation.screens.contacts_list

import androidx.lifecycle.viewModelScope
import com.example.androidtestcase.domain.Contact
import com.example.androidtestcase.navigation.screens.ContactDetailsScreen
import com.example.androidtestcase.presentation.base.BaseVM
import com.example.androidtestcase.presentation.base.LoadingState

class ContactsListVM(
    private val contactsPagerLoader: ContactsPagerLoader
) : BaseVM<ContactsListState>() {

    override val state: ContactsListState = ContactsListState()

    fun loadContacts() {
        contactsPagerLoader.loadItems(
            viewModelScope,
            {
                state.loading = LoadingState.Loading
                render(state)
            },
            {
                state.updateContacts(it)
                state.loading = LoadingState.None
                val unique = state.contacts.toSet()
                render(state)
            },
            {
                onError(it)
            }
        )
    }

    fun onContactClick(item: Contact) {
        router.navigateTo(ContactDetailsScreen(item))
    }
}