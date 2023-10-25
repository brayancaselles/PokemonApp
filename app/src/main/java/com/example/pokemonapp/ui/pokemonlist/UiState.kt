package com.example.pokemonapp.ui.pokemonlist

import com.example.pokemonapp.data.remote.network.Response.Pokemon

data class UiState(
    val isLoading: Boolean = false,
    val pokemonList: List<Pokemon>? = null,
    val error: String? = null,
)
