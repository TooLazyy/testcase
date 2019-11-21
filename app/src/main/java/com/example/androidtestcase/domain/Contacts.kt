package com.example.androidtestcase.domain

import java.io.Serializable

data class Contacts(
    val hasMore: Boolean,
    val contacts: List<Contact>
)

data class Contact(
    val photoBig: String,
    val photoSmall: String,
    val name: String?,
    val age: Int,
    val sex: Sex,
    val id: Long,
    val message: Message?
) : Serializable {

    val hasLastMessage: Boolean
        get() = message != null && message.text.trim().isNotEmpty()
}

data class Message(
    val text: String,
    val time: Long
) : Serializable

private const val SEX_MALE = 1
private const val SEX_FEMALE = 2

sealed class Sex {

    object Male : Sex()
    object Female : Sex()

    companion object {

        fun fromSexValue(sex: Int?): Sex {
            return when (sex) {
                SEX_MALE -> Male
                SEX_FEMALE -> Female
                else -> Male
            }
        }
    }
}