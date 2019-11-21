package com.example.androidtestcase.di

import com.example.androidtestcase.data.contacts.ContactsRepository
import com.example.androidtestcase.data.contacts.ContactsRepositoryImpl
import org.koin.dsl.module

val contactsDataModule = module {

    single<ContactsRepository> { ContactsRepositoryImpl(get(), get(), get()) }
}