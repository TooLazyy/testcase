package com.example.androidtestcase.presentation.screens.contacts_list

import com.example.androidtestcase.data.contacts.ContactsRepository
import com.example.androidtestcase.data.utils.RequestResult
import com.example.androidtestcase.domain.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ContactsPagerLoader(
    private val repository: ContactsRepository
) {

    private val pagesUrls = listOf(
        "https://api.myjson.com/bins/vboaf",
        "https://api.myjson.com/bins/rlyny"
    )
    private var pageInfo = PageInfo()
    private val sourcePageUrl: String
        get() = pagesUrls[pageInfo.pageNumber]

    fun loadItems(
        scope: CoroutineScope,
        onLoadStart: () -> Unit,
        onLoadSuccess: (List<Contact>) -> Unit,
        onLoadError: (Throwable) -> Unit
    ) {
        if (!pageInfo.hasMoreItems) {
            return
        }
        if (pageInfo.isLoading) {
            return
        }
        pageInfo = pageInfo.copy(isLoading = true)
        onLoadStart()
        scope.launch {
            when (val result = repository.loadContacts(sourcePageUrl)) {
                is RequestResult.Success -> {
                    pageInfo = pageInfo.copy(
                        isLoading = false,
                        hasMoreItems = result.data.hasMore,
                        pageNumber = pageInfo.pageNumber + 1
                    )
                    onLoadSuccess(result.data.contacts)
                }
                is RequestResult.Error -> {
                    pageInfo = pageInfo.copy(isLoading = false)
                    onLoadError(result.error)
                }
            }
        }
    }
}

data class PageInfo(
    val isLoading: Boolean = false,
    val hasMoreItems: Boolean = true,
    val pageNumber: Int = 0
)