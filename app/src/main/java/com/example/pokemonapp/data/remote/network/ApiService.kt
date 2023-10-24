package com.example.pokemonapp.data.remote.network

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ApiService {
    fun fetchDataFromApi(
        isSearchPokemon: Boolean = false,
        pokemonNameToSearch: String = "",
    ): String {
        val baseUrl = "https://pokeapi.co/api/v2/pokemon/"

        val apiUrl = if (isSearchPokemon) {
            "$baseUrl$pokemonNameToSearch/"
        } else {
            baseUrl
        }
        val url = URL(apiUrl)
        val connection = url.openConnection() as HttpURLConnection

        val response = StringBuilder()

        try {
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                response.append(line)
            }
            reader.close()
        } finally {
            connection.disconnect()
        }

        return response.toString()
    }
}
