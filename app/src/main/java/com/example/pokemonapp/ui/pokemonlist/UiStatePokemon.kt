package com.example.pokemonapp.ui.pokemonlist

import com.example.pokemonapp.domain.model.PokemonModel

data class UiStatePokemon(
    val isLoading: Boolean = false,
    val pokemonList: List<PokemonModel>? = null,
)
