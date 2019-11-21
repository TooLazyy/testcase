package com.example.androidtestcase.navigation.screens

import androidx.fragment.app.Fragment
import com.example.androidtestcase.domain.Contact
import com.example.androidtestcase.presentation.screens.contact_details.ContactDetailsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ContactDetailsScreen(
    private val contact: Contact
) : SupportAppScreen() {

    override fun getScreenKey(): String = ContactDetailsFragment.TAG

    override fun getFragment(): Fragment = ContactDetailsFragment.getInstance(contact)
}