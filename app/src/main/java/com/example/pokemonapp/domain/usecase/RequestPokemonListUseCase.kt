package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.data.repository.Repository
import com.example.pokemonapp.domain.model.PokemonModel
import javax.inject.Inject

class RequestPokemonListUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(): List<PokemonModel>? {
        return repository.getPokemonListFromApi()
    }
}
