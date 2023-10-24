package com.example.pokemonapp.data.remote.network.Response

import org.json.JSONArray
import org.json.JSONObject

data class PokemonListModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Pokemon>,
) {
    constructor(json: JSONObject) : this(
        json.getInt("count"),
        json.getString("next"),
        json.getJSONObject("previous"),
        parseResultsPokemonList(json.getJSONArray("results")),
    )

    companion object {
        private fun parseResultsPokemonList(resultsArray: JSONArray): List<Pokemon> {
            val resultsList = mutableListOf<Pokemon>()
            for (i in 0 until resultsArray.length()) {
                val resultObject = resultsArray.getJSONObject(i)
                val result = Pokemon(
                    resultObject.getString("name"),
                    resultObject.getString("url"),
                )
                resultsList.add(result)
            }
            return resultsList
        }
    }
}
