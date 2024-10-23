package com.example.newpokedex.data

import com.example.newpokedex.data.entity.PokemonEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import java.io.IOException

class PokemonService(private val client: HttpClient) {

   suspend fun getPokemon(id: Int): Result<PokemonEntity> {
        return runCatching {
           val response = client.get("v1/pokemon/$id")
            if (response.status.isSuccess()) {
                return@runCatching response.body<PokemonEntity>()
            } else {
                throw IOException()
            }
        }
    }
}