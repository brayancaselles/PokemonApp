package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.data.remote.network.Response.Pokemon

interface IGetPokemonListUseCase {

    suspend operator fun invoke(): List<Pokemon>?
}
