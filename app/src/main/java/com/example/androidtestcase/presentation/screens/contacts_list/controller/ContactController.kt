package com.example.androidtestcase.presentation.screens.contacts_list.controller

import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.androidtestcase.R
import com.example.androidtestcase.domain.Contact
import com.example.androidtestcase.extensions.DateTimeFormatter
import com.example.androidtestcase.extensions.getSexString
import com.example.androidtestcase.extensions.loadImage
import kotlinx.android.synthetic.main.item_contact.view.*
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class ContactController(
    private val onItemClickAction: (Contact) -> Unit
) : BindableItemController<Contact, ContactController.Holder>() {

    override fun getItemId(item: Contact): String = item.id.toString()

    override fun createViewHolder(parent: ViewGroup?): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup?) :
        BindableViewHolder<Contact>(parent, R.layout.item_contact) {

        override fun bind(item: Contact) {
            itemView.setOnClickListener {
                onItemClickAction(item)
            }
            itemView.run {
                iv_avatar.loadImage(item.photoSmall)
                tv_name.text = item.name
                tv_info.text = context.getString(
                    R.string.contacts_contact_info,
                    item.sex.getSexString(context),
                    item.age
                )

                item.message?.let {
                    tv_message.text = it.text
                    tv_time.text = DateTimeFormatter.formatTime(it.time)
                }
                g_last_message.isVisible = item.hasLastMessage
            }
        }
    }
}