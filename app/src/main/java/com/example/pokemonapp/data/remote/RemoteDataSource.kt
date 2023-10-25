package com.example.pokemonapp.data.remote

import com.example.pokemonapp.data.datasource.IRemoteDataSource
import com.example.pokemonapp.data.remote.network.IApiService
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: IApiService) :
    IRemoteDataSource {

    override suspend fun getPokemonListFromApi(): JSONArray? {
        val apiResponseJson = apiService.fetchDataFromApi()

        try {
            val jsonObject = JSONObject(apiResponseJson)

            return jsonObject.getJSONArray("pokemon_species")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}
