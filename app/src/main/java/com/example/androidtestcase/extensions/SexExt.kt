package com.example.androidtestcase.extensions

import android.content.Context
import com.example.androidtestcase.R
import com.example.androidtestcase.domain.Sex

fun Sex.getSexString(context: Context): String {
    return context.getString(
        when (this) {
            is Sex.Male -> R.string.contacts_sex_male
            is Sex.Female -> R.string.contacts_sex_female
        }
    )
}