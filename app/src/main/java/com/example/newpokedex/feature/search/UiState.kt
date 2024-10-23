package com.example.newpokedex.feature.search


data class UiState(
    val inputValue: String
){
    companion object {
        val Default = UiState(
            inputValue = ""
        )
    }
}
