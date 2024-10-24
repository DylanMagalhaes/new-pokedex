package com.example.newpokedex.feature.search

import com.example.newpokedex.domain.model.Pokemon


data class UiState(
    val inputValue: String,
    val pokemon: Pokemon?,
) {
    companion object {
        val Default = UiState(
            inputValue = "",
            pokemon = null,
        )
    }
}
