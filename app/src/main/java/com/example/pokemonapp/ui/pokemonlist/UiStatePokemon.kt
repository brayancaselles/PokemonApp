package com.example.pokemonapp.ui.pokemonlist

import com.example.pokemonapp.domain.model.Error
import com.example.pokemonapp.domain.model.PokemonModel

data class UiStatePokemon(
    val isLoading: Boolean = true,
    val pokemonList: List<PokemonModel>? = null,
    val error: Error? = null,
)
