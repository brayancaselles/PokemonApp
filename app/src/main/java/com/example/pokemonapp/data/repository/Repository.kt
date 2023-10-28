package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.datasource.IRemoteDataSource
import com.example.pokemonapp.domain.model.PokemonDetailModel
import com.example.pokemonapp.domain.model.PokemonModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
) {

    fun requestPokemonListFromApi(): Flow<List<PokemonModel>> {
        return remoteDataSource.requestPokemonListFromApi()
    }

    fun requestDetailPokemonFromApi(namePokemon: String): Flow<PokemonDetailModel> {
        return remoteDataSource.requestDetailPokemonFromApi(namePokemon)
    }
}
