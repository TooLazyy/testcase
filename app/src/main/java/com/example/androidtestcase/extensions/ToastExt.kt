package com.example.androidtestcase.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(text: String, length:Int = Toast.LENGTH_LONG) {
    Toast.makeText(requireContext(), text, length).show()
}