package com.example.androidtestcase.presentation.screens.contacts_list.controller

import android.view.ViewGroup
import com.example.androidtestcase.R
import ru.surfstudio.android.easyadapter.controller.NoDataItemController
import ru.surfstudio.android.easyadapter.holder.BaseViewHolder

class LoaderController : NoDataItemController<LoaderController.Holder>() {

    override fun createViewHolder(parent: ViewGroup?): Holder = Holder(parent)

    inner class Holder(parent: ViewGroup?) : BaseViewHolder(parent, R.layout.item_loader)
}