package com.example.pokemonapp.data.datasource

import com.example.pokemonapp.data.remote.network.Response.Pokemon
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {

    val pokemonList: Flow<List<Pokemon>>

    suspend fun isEmpty(): Boolean
}
