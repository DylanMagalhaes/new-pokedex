package com.example.newpokedex.data.repository

import com.example.newpokedex.data.PokemonService
import com.example.newpokedex.data.entity.toModel
import com.example.newpokedex.domain.model.Pokemon

class PokemonRepository(private val service: PokemonService) {

    suspend fun getPokemon(id: Int): Result<Pokemon> {
        return service.getPokemon(id).map { it.toModel() }
    }

}