package com.example.androidtestcase.navigation.screens

import androidx.fragment.app.Fragment
import com.example.androidtestcase.presentation.screens.contacts_list.ContactsListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ContactsListScreen : SupportAppScreen() {

    override fun getScreenKey(): String = ContactsListFragment.TAG

    override fun getFragment(): Fragment = ContactsListFragment()
}