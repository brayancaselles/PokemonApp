package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.data.remote.network.Response.Pokemon
import com.example.pokemonapp.data.repository.Repository
import javax.inject.Inject

class RequestPokemonListUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(): List<Pokemon>? {
        return repository.getPokemonListFromApi()
    }
}
