package com.hoon.dustsearch

import android.app.Application
import android.content.Context


class Application : Application() {
    lateinit var context: Context

    init{
        instance = this
    }
    companion object {
        private var instance: Application? = null
        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}


