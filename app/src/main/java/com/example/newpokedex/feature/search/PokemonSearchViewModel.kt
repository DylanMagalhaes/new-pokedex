package com.example.newpokedex.feature.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PokemonSearchViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(UiState.Default)
    val uiState = _uiState.asStateFlow()

    fun onSearchInputChange(input: String) {
        _uiState.update {
            it.copy(inputValue = input)
        }
    }
}

// KOIN pour injection de dependance

// KTOR CLIENT pour apl réseaux