package com.example.androidtestcase.extensions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateTimeFormatter {

    @SuppressLint("ConstantLocale")
    private val lastMessageFormatter = SimpleDateFormat("HH:mm", Locale.getDefault())

    fun formatTime(time: Long): String {
        return try {
            lastMessageFormatter.format(Date(time))
        } catch (ex: Exception) {
            ""
        }
    }
}