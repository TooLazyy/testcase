package com.example.androidtestcase.presentation.screens.contacts_list

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtestcase.R
import com.example.androidtestcase.data.error.errors.NoInternetApiError
import com.example.androidtestcase.data.error.errors.UnspecifiedApiError
import com.example.androidtestcase.domain.Contact
import com.example.androidtestcase.extensions.EventObserver
import com.example.androidtestcase.extensions.setOnLoadMoreListener
import com.example.androidtestcase.extensions.toast
import com.example.androidtestcase.presentation.base.BaseFragment
import com.example.androidtestcase.presentation.screens.contacts_list.controller.ContactController
import com.example.androidtestcase.presentation.screens.contacts_list.controller.LoaderController
import kotlinx.android.synthetic.main.fragment_contacts_list.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList

class ContactsListFragment : BaseFragment(R.layout.fragment_contacts_list) {

    companion object {

        const val TAG = "ContactsListFragment"
    }

    private val vm: ContactsListVM by viewModel()
    private val adapter = EasyAdapter()
    private val loaderController = LoaderController()
    private val contactController = ContactController(::onContactClicked)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
        subscribeToState()
        vm.loadContacts()
    }

    private fun subscribeToState() {
        vm.stateData.observe(viewLifecycleOwner, Observer {
            adapter.setItems(
                ItemList.create()
                    .addAllIf(it.hasItems, it.contacts, contactController)
                    .addIf(it.hasLoadingItem, loaderController)
            )
        })
        vm.errorData.observe(viewLifecycleOwner, EventObserver {
            when (it) {
                is NoInternetApiError -> toast(getString(R.string.error_not_internet))
                is UnspecifiedApiError -> toast(getString(R.string.error_unknown))
            }
            removeLoadingItem()
        })
    }

    private fun removeLoadingItem() {
        adapter.setItems(
            ItemList.create()
        )
    }

    private fun initRecycler() {
        rv_contacts.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ContactsListFragment.adapter
            itemAnimator = null
            addItemDecoration(
                ContactsListItemDecoration(
                    requireContext().resources.getDimensionPixelOffset(R.dimen.contacts_list_item_offset)
                )
            )
            setOnLoadMoreListener {
                vm.loadContacts()
            }
        }
    }

    private fun onContactClicked(item: Contact) {
        vm.onContactClick(item)
    }
}