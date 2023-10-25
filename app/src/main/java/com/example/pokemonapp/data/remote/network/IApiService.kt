package com.example.pokemonapp.data.remote.network

interface IApiService {
    suspend fun fetchDataFromApi(
        apiUrl: String = "https://pokeapi.co/api/v2/generation/1/",
    ): String
}
