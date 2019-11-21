package com.example.androidtestcase.di

import com.example.androidtestcase.data.api.ContactsApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val DEFAULT_BASE_URL = "http://ya.ru/"
private const val READ_TIMEOUT = 30L
private const val WRITE_TIMEOUT = 30L
private const val CONNECT_TIMEOUT = 30L

val networkModule = module {

    single<Gson> { GsonBuilder().create() }
    single { GsonConverterFactory.create(get()) }

    single {
        OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        }
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(DEFAULT_BASE_URL)
            .client(get())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    single<ContactsApi> { get<Retrofit>().create(ContactsApi::class.java) }
}
