package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.data.repository.Repository
import com.example.pokemonapp.domain.model.PokemonModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RequestPokemonListUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Flow<List<PokemonModel>> {
        return repository.requestPokemonListFromApi()
    }
}
