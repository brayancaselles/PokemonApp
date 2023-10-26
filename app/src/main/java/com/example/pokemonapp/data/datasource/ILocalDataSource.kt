package com.example.pokemonapp.data.datasource

import com.example.pokemonapp.domain.model.PokemonModel
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {

    val pokemonList: Flow<List<PokemonModel>>

    suspend fun isEmpty(): Boolean
}
