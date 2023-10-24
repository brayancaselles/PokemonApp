package com.example.pokemonapp.data.remote

import com.example.pokemonapp.data.datasource.IRemoteDataSource
import com.example.pokemonapp.data.remote.network.ApiService
import com.example.pokemonapp.data.remote.network.Response.PokemonListModel
import org.json.JSONArray

class RemoteDataSource(private val apiService: ApiService) : IRemoteDataSource {

    override suspend fun getPokemonListFromApi(): PokemonListModel? {
        val apiResponseJson = apiService.fetchDataFromApi()

        try {
            val jsonArray = JSONArray(apiResponseJson)
            if (jsonArray.length() > 0) {
                val jsonObject = jsonArray.getJSONObject(0)
                return PokemonListModel(jsonObject)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}
