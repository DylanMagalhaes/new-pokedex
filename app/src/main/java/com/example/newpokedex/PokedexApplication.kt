package com.example.newpokedex

import android.app.Application
import com.example.newpokedex.data.injection.module.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class PokedexApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {

            androidLogger()
            androidContext(this@PokedexApplication)
            modules(networkModule)
        }
    }
}