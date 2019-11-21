package com.example.androidtestcase.data.utils

fun <T> List<Transformable<T>>.transform(): List<T> =
    map { it.transform() }