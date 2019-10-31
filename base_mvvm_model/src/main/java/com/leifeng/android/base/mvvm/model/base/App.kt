package com.leifeng.android.base.mvvm.model.base

import android.app.Application

internal class App : Application(){

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        val INSTANCE: App by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { App() }
    }
}
