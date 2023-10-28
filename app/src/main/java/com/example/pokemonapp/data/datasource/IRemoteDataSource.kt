package com.example.pokemonapp.data.datasource

import com.example.pokemonapp.domain.model.PokemonDetailModel
import com.example.pokemonapp.domain.model.PokemonModel
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {

    fun requestPokemonListFromApi(): Flow<List<PokemonModel>>

    fun requestDetailPokemonFromApi(namePokemon: String): Flow<PokemonDetailModel>
}
