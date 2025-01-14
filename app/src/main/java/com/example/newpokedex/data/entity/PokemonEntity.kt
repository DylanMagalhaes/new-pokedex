package com.example.newpokedex.data.entity

import com.example.newpokedex.domain.model.Pokemon
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonEntity(
    @SerialName("pokedex_id") val id: Int,
    @SerialName("name") val name: Name,
    @SerialName("sprites") val sprites: Sprites,
)

@Serializable
data class Name(
    @SerialName("fr") val fr: String,
)

@Serializable
data class Sprites(
    @SerialName("regular") val regularUrl: String,
)


fun PokemonEntity.toModel(): Pokemon {
    return Pokemon(
        id = id,
        name = name.fr,
        imageUrl = sprites.regularUrl,
    )
}