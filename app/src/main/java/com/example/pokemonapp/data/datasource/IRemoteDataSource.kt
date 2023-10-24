package com.example.pokemonapp.data.datasource

import com.example.pokemonapp.data.remote.network.Response.PokemonListModel

interface IRemoteDataSource {

    suspend fun getPokemonListFromApi(): PokemonListModel?
}
