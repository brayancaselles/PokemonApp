package com.example.pokemonapp.data.local

import com.example.pokemonapp.data.datasource.ILocalDataSource
import com.example.pokemonapp.data.remote.network.Response.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor() : ILocalDataSource {
    override val pokemonList: Flow<List<Pokemon>>
        get() = TODO("Not yet implemented")

    override suspend fun isEmpty(): Boolean = true // pokemonDao.pokemonCount == 0
}
