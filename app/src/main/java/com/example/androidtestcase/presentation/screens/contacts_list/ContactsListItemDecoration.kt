package com.example.androidtestcase.presentation.screens.contacts_list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtestcase.presentation.screens.contacts_list.controller.ContactController
import kotlin.reflect.KClass

class ContactsListItemDecoration(
    private val marginPx: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val count = (parent.adapter?.itemCount ?: 0) - 1
        if (position == 0) {
            return
        }
        val viewHolderClass = getViewHolderClassAtPosition(parent, position)
        if (viewHolderClass == null || viewHolderClass != ContactController.Holder::class) {
            return
        }
        outRect.top = marginPx
        if (position == count) {
            outRect.bottom = marginPx
        }
    }

    private fun getViewHolderClassAtPosition(
        parent: RecyclerView,
        position: Int
    ): KClass<*>? {
        val lm = parent.layoutManager as? LinearLayoutManager ?: return null
        val childView: View? = lm.findViewByPosition(position)
        return childView?.let { view ->
            val holder = parent.getChildViewHolder(view)
            holder?.javaClass?.kotlin
        }
    }
}