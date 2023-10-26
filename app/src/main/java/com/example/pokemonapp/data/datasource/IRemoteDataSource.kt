package com.example.pokemonapp.data.datasource

import org.json.JSONArray

interface IRemoteDataSource {

    suspend fun getPokemonListFromApi(): JSONArray?

    suspend fun getDetailPokemonFromApi(namePokemon: String): JSONArray?
}
