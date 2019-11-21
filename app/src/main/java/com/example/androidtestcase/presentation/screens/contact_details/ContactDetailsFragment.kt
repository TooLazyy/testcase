package com.example.androidtestcase.presentation.screens.contact_details

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.example.androidtestcase.R
import com.example.androidtestcase.domain.Contact
import com.example.androidtestcase.extensions.loadImage
import com.example.androidtestcase.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_contact_details.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ContactDetailsFragment : BaseFragment(R.layout.fragment_contact_details) {

    companion object {

        const val TAG = "ContactDetailsFragment"
        private const val ARG_CONTACT = "contact"

        fun getInstance(contact: Contact): ContactDetailsFragment =
            ContactDetailsFragment().apply {
                arguments = bundleOf(ARG_CONTACT to contact)
            }
    }

    private val vm: ContactDetailsVM by viewModel {
        parametersOf(arguments?.getSerializable(ARG_CONTACT) as Contact)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initToolbar()
        subscribeToState()
        vm.loadContact()
    }

    private fun subscribeToState() {
        vm.stateData.observe(viewLifecycleOwner, Observer {
            render(it.contact)
        })
    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            vm.exit()
        }
    }

    private fun render(contact: Contact) {
        iv_photo.loadImage(contact.photoBig)
        toolbar.title = getString(R.string.contact_details_title, contact.name, contact.age)
    }
}