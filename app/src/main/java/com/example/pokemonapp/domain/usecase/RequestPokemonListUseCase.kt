package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.data.remote.network.Response.Pokemon
import com.example.pokemonapp.domain.IRepository

class RequestPokemonListUseCase(private val repository: IRepository) : IGetPokemonListUseCase {
    override suspend operator fun invoke(): List<Pokemon>? {
        return repository.getPokemonListFromApi()
    }
}
