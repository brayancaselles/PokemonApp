package com.example.pokemonapp.data.remote

import android.graphics.Bitmap
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

    override suspend fun getDetailPokemonFromApi(namePokemon: String): JSONObject? {
        val completeUrl = "pokemon/$namePokemon"

        val apiResponse = apiService.fetchDataFromApi(completeUrl)

        var response: JSONObject? = null
        try {
            response = JSONObject(apiResponse)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return response
    }

    override suspend fun downloadImages(imageUrls: List<String>): List<Bitmap?> {
        return apiService.downloadImagesParallelFromApi(imageUrls)
    }
}
