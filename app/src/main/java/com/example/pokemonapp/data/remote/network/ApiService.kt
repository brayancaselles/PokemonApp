package com.example.pokemonapp.data.remote.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStream
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

        return response.toString()
    }

    /*override suspend fun downloadImage(imageUrl: String): Bitmap? {
        var bitmap: Bitmap? = null
        withContext(Dispatchers.IO) {
            try {
                val url = URL(imageUrl)
                val connection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input: InputStream = connection.inputStream
                bitmap = BitmapFactory.decodeStream(input)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        Log.d("RESPONSE -----> IMAGE", "bitmap -> $bitmap")
        return bitmap
    }*/

    override suspend fun downloadImagesParallelFromApi(imageUrls: List<String>): List<Bitmap?> {
        return withContext(Dispatchers.IO) {
            val deferredBitmaps = imageUrls.map { imageUrl ->
                async {
                    try {
                        val url = URL(imageUrl)
                        val connection = url.openConnection() as HttpURLConnection
                        connection.doInput = true
                        connection.connect()
                        val input: InputStream = connection.inputStream
                        BitmapFactory.decodeStream(input)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        null
                    }
                }
            }

            Log.d("tag", "bitmap -> $deferredBitmaps")

            deferredBitmaps.awaitAll()
        }
    }
}
