package com.example.androidtestcase.extensions

import androidx.lifecycle.Observer

class Event<T>(
    private val event: T
) {
    @Volatile
    private var isEventConsumed = false

    val eventValue: T?
        get() {
            return if (!isEventConsumed) {
                isEventConsumed = true
                event
            } else {
                null
            }
        }
}

class EventObserver<T>(
    private val onEventChanged: (T) -> Unit
) : Observer<Event<T>> {

    override fun onChanged(event: Event<T>?) {
        event?.let { value ->
            value.eventValue?.let {
                onEventChanged(it)
            }
        }
    }
}