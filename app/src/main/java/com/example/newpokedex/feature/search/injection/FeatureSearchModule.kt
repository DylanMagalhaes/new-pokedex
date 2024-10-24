package com.example.newpokedex.feature.search.injection

import com.example.newpokedex.feature.search.PokemonSearchViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureSearchModule = module {
    viewModelOf(::PokemonSearchViewModel)
}