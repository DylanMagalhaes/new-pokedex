package com.example.newpokedex

import android.app.Application
import com.example.newpokedex.data.injection.module.networkModule
import com.example.newpokedex.feature.search.injection.featureSearchModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class PokedexApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}

private fun Application.initKoin() {
    startKoin {
        androidLogger()
        androidContext(this@initKoin)
        modules(networkModule, featureSearchModule)
    }
}