package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.datasource.ILocalDataSource
import com.example.pokemonapp.data.datasource.IRemoteDataSource
import com.example.pokemonapp.data.remote.network.Response.Pokemon
import com.example.pokemonapp.domain.IRepository

class Repository(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource,
) : IRepository {
    override suspend fun getPokemonListFromApi(): List<Pokemon>? {
        return remoteDataSource.getPokemonListFromApi()?.results
    }
}
