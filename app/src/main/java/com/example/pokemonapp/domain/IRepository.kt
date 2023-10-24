package com.example.pokemonapp.domain

import com.example.pokemonapp.data.remote.network.Response.Pokemon

interface IRepository {

    suspend fun getPokemonListFromApi(): List<Pokemon>?
}
