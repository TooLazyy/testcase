package com.example.androidtestcase.data.contacts.response

import com.example.androidtestcase.data.utils.Transformable
import com.example.androidtestcase.data.utils.toBigPhotoPath
import com.example.androidtestcase.data.utils.toSmallPhotoPath
import com.example.androidtestcase.data.utils.transform
import com.example.androidtestcase.domain.Contact
import com.example.androidtestcase.domain.Contacts
import com.example.androidtestcase.domain.Message
import com.example.androidtestcase.domain.Sex
import com.google.gson.annotations.SerializedName

const val HAS_MORE = 1

class ContactsResponseObj(
    @SerializedName("has_more") val hasMore: Int?,
    @SerializedName("errno") val hasError: Int?,
    @SerializedName("user") val contacts: List<ContactObj>?
) : Transformable<Contacts> {

    override fun transform(): Contacts =
        Contacts(
            hasMore == HAS_MORE,
            contacts?.transform() ?: listOf()
        )
}

class ContactObj(
    @SerializedName("foto") val photo: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("age") val age: Int?,
    @SerializedName("sex") val sex: Int?,
    @SerializedName("uid") val id: Long?,
    @SerializedName("message") val message: MessageObj?
) : Transformable<Contact> {

    override fun transform(): Contact =
        Contact(
            photo.toBigPhotoPath(),
            photo.toSmallPhotoPath(),
            name ?: "",
            age ?: 0,
            Sex.fromSexValue(sex),
            id ?: 0L,
            message?.transform()
        )
}

class MessageObj(
    @SerializedName("msg") val text: String?,
    @SerializedName("time") val time: Long?
) : Transformable<Message> {

    override fun transform(): Message =
        Message(
            text ?: "",
            time ?: 0L
        )
}