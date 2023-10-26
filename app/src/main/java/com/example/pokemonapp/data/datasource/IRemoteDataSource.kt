package com.example.pokemonapp.data.datasource

import android.graphics.Bitmap
import org.json.JSONArray
import org.json.JSONObject

interface IRemoteDataSource {

    suspend fun getPokemonListFromApi(): JSONArray?

    suspend fun getDetailPokemonFromApi(namePokemon: String): JSONObject?

    suspend fun downloadImages(imageUrls: List<String>): List<Bitmap?>
}
