package com.hoon.dustsearch

import android.app.Application
import com.hoon.dustsearch.viewModel.MainViewModel
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}


