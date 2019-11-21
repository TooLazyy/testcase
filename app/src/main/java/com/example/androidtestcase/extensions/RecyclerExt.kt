package com.example.androidtestcase.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val LOAD_MORE_THRESHOLD = 5

fun RecyclerView.setOnLoadMoreListener(
    threshHold: Int = LOAD_MORE_THRESHOLD,
    listener: () -> Unit
) {
    val lm = layoutManager as? LinearLayoutManager ?: return
    addOnScrollListener(LoadMoreScrollListener(lm, threshHold, listener))
}

class LoadMoreScrollListener(
    private val lm: LinearLayoutManager,
    private val threshHold: Int,
    private val onLoadMore: () -> Unit
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

        if (dy > 0) {
            val itemCount = lm.itemCount - 1 //constant for EasyAdapter
            val lastVisibleItem = lm.findLastVisibleItemPosition()
            val itemsLeft = itemCount - lastVisibleItem

            if (itemsLeft <= threshHold) {
                onLoadMore()
            }
        }
    }
}