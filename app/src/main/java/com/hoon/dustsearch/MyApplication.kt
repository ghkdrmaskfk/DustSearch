package com.hoon.dustsearch

import android.app.Application
import com.hoon.dustsearch.viewModel.MainViewModel
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


class MyApplication : Application() {

    var modelPart = module { factory<DataModel> { DataModelImpl() } }

    var viewModelPart = module { viewModel { MainViewModel(get()) } }

    var myDiModule = listOf(modelPart, viewModelPart)

    override fun onCreate() {
        super.onCreate()

        startKoin(applicationContext, myDiModule)
    }
}

interface DataModel {
    fun getData()
}

class DataModelImpl: DataModel {
    override fun getData() {
        return
    }
}

