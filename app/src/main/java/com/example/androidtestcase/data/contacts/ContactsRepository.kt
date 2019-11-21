package com.example.androidtestcase.data.contacts

import com.example.androidtestcase.data.utils.RequestResult
import com.example.androidtestcase.domain.Contacts

interface ContactsRepository {

    suspend fun loadContacts(sourceUrl: String): RequestResult<Contacts>
}