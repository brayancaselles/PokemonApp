package com.example.pokemonapp.data.remote

import com.example.pokemonapp.data.datasource.IRemoteDataSource
import com.example.pokemonapp.data.remote.network.IApiService
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: IApiService) :
    IRemoteDataSource {

    override suspend fun getPokemonListFromApi(): JSONArray? {
        val apiResponseJson = apiService.fetchDataFromApi("generation/1/")

        var response: JSONArray? = null
        try {
            val jsonObject = JSONObject(apiResponseJson)
            response = jsonObject.getJSONArray("pokemon_species")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return response
    }

    override suspend fun getDetailPokemonFromApi(namePokemon: String): JSONArray? {
        val completeUrl = "pokemon/$namePokemon"

        val apiResponse = apiService.fetchDataFromApi(completeUrl)

        var response: JSONArray? = null
        try {
            val jsonObject = JSONObject(apiResponse)
            println("Response -----------> $jsonObject")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return response
    }
}
