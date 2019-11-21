package com.example.androidtestcase.data.utils

private const val PATH_CHAR_TO_REPLACE = '@'

fun String?.toBigPhotoPath(): String {
    return if (this == null) {
        ""
    } else {
        val index = this.indexOfLast { it == PATH_CHAR_TO_REPLACE }
        if (index != -1) {
            this.replaceRange(index, index + 1, "b_")
        } else {
            ""
        }
    }
}

fun String?.toSmallPhotoPath(): String {
    return if (this == null) {
        ""
    } else {
        val index = this.indexOfLast { it == PATH_CHAR_TO_REPLACE }
        if (index != -1) {
            this.replaceRange(index, index + 1, "m_")
        } else {
            ""
        }
    }
}