package com.example.androidtestcase.data.api

import com.example.androidtestcase.data.contacts.response.ContactsResponseObj
import retrofit2.http.GET
import retrofit2.http.Url

interface ContactsApi {

    @GET
    suspend fun loadContacts(@Url url: String): ContactsResponseObj
}