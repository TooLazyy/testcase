package com.example.androidtestcase

import android.app.Application
import com.example.androidtestcase.di.contactsDataModule
import com.example.androidtestcase.di.dataModule
import com.example.androidtestcase.di.navigationModule
import com.example.androidtestcase.di.networkModule
import com.example.androidtestcase.presentation.screens.contact_details.contactDetailsModule
import com.example.androidtestcase.presentation.screens.contacts_list.contactsModule
import com.example.androidtestcase.presentation.screens.main.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(
                listOf(
                    dataModule,
                    networkModule,
                    navigationModule,
                    contactsDataModule,
                    mainModule,
                    contactsModule,
                    contactDetailsModule
                )
            )
        }
    }
}