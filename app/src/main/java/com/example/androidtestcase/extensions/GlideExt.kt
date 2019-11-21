package com.example.androidtestcase.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidtestcase.R

fun ImageView.loadImage(url: String) {
    val ops = RequestOptions()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
    Glide
        .with(context)
        .load(url)
        .apply(ops)
        .into(this)
}