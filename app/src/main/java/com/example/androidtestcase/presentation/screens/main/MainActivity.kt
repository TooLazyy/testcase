package com.example.androidtestcase.presentation.screens.main

import android.os.Bundle
import com.example.androidtestcase.R
import com.example.androidtestcase.presentation.base.BaseNavigatorActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseNavigatorActivity() {

    override val containerId: Int = R.id.f_container

    private val vm: MainVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            vm.openInitialScreen()
        }
    }
}
