package com.example.pokemonapp.data.remote.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject

class ApiService @Inject constructor() : IApiService {
    override suspend fun fetchDataFromApi(
        apiUrl: String,
    ): String {
        val baseUrl = "https://pokeapi.co/api/v2/"

        val createUrl = "$baseUrl$apiUrl"

        val url = URL(createUrl)
        val connection = url.openConnection() as HttpURLConnection

        val response = StringBuilder()

        try {
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            withContext(Dispatchers.IO) {
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    response.append(line)
                }
                reader.close()
            }
        } finally {
            connection.disconnect()
        }

        Log.d("RESPONSE ----->", response.toString())
        return response.toString()
    }
}
