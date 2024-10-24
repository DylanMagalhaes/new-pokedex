package com.example.newpokedex.feature.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newpokedex.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonSearchViewModel(
    private val repository: PokemonRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState.Default)
    val uiState = _uiState.asStateFlow()

    fun onSearchInputChange(input: String) {
        _uiState.update {
            it.copy(inputValue = input)
        }
    }

    fun onSearchButtonClicked() {
        val id = uiState.value.inputValue.toIntOrNull() ?: return

        viewModelScope.launch {
            repository.getPokemon(id)
                .onSuccess { pokemon ->
                    _uiState.update { it.copy(pokemon = pokemon) }
                }
                .onFailure {
                    Log.e("PokemonSearchViewModel","getPokemon failed -> $it")
                }
        }
    }
}