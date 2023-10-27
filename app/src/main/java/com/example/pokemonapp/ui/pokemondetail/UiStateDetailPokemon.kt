package com.example.pokemonapp.ui.pokemondetail

import com.example.pokemonapp.domain.model.Error
import com.example.pokemonapp.domain.model.PokemonDetailModel

data class UiStateDetailPokemon(
    val isLoading: Boolean = true,
    val detailPokemon: PokemonDetailModel? = null,
    val error: Error? = null,
)
