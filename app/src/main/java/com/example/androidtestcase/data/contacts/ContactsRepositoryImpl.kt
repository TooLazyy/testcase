package com.example.androidtestcase.data.contacts

import com.example.androidtestcase.data.api.ContactsApi
import com.example.androidtestcase.data.base.BaseRepository
import com.example.androidtestcase.data.error.ErrorHandler
import com.example.androidtestcase.data.utils.RequestResult
import com.example.androidtestcase.data.utils.dispatchers.DispatchersProvider
import com.example.androidtestcase.data.utils.wrapResult
import com.example.androidtestcase.domain.Contacts
import kotlinx.coroutines.withContext

class ContactsRepositoryImpl(
    errorHandler: ErrorHandler,
    private val api: ContactsApi,
    private val dispatchers: DispatchersProvider
) : BaseRepository(errorHandler),
    ContactsRepository {

    override suspend fun loadContacts(sourceUrl: String): RequestResult<Contacts> =
        withContext(dispatchers.default()) {
            wrapResult {
                api.loadContacts(sourceUrl).transform()
            }
                .handleError()
        }
}