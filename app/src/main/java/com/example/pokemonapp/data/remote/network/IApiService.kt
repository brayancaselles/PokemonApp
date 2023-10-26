package com.example.pokemonapp.data.remote.network

import android.graphics.Bitmap

interface IApiService {
    suspend fun fetchDataFromApi(
        apiUrl: String,
    ): String

    suspend fun downloadImagesParallelFromApi(imageUrls: List<String>): List<Bitmap?>
}
