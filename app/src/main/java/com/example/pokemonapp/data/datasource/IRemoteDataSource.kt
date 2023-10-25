package com.example.pokemonapp.data.datasource

import com.example.pokemonapp.data.remote.network.Response.PokemonListModel
import org.json.JSONArray

interface IRemoteDataSource {

    suspend fun getPokemonListFromApi(): JSONArray?
}
