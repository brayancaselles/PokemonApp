package com.example.pokemonapp.ui.pokemondetail

import com.example.pokemonapp.domain.model.PokemonDetailModel

data class UiStateDetailPokemon(
    val isLoading: Boolean = false,
    val detailPokemon: List<PokemonDetailModel>? = null,
)
