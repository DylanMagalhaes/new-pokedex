package com.example.newpokedex.data.injection.module

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

private const val BASE_URL = "https://tyradex.vercel.app/api/"


val networkModule = module {

    single {
        HttpClient(Android) {
            install(ContentNegotiation){
                json()
            }
            defaultRequest { url(BASE_URL) }
        }
    }
}