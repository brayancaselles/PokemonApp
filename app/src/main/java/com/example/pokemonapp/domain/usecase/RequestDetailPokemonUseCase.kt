package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.data.repository.Repository
import com.example.pokemonapp.domain.model.PokemonDetailModel
import javax.inject.Inject

class RequestDetailPokemonUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(namePokemon: String): List<PokemonDetailModel>? {
        return repository.getDetailPokemonFromApi(namePokemon)
    }
}
