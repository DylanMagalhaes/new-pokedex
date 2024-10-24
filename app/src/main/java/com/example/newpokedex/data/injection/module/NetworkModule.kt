package com.example.newpokedex.data.injection.module

import com.example.newpokedex.data.PokemonService
import com.example.newpokedex.data.repository.PokemonRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

private const val BASE_URL = "https://tyradex.vercel.app/api/"


val networkModule = module {

    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
            defaultRequest { url(BASE_URL) }
        }
    }

    single {
        PokemonService(get<HttpClient>())
    }

    single {
        PokemonRepository(get<PokemonService>())
    }
}