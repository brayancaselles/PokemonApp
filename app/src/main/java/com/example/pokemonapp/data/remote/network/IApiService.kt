package com.example.pokemonapp.data.remote.network

interface IApiService {
    suspend fun fetchDataFromApi(
        apiUrl: String,
    ): String
}
