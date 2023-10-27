package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.data.repository.Repository
import com.example.pokemonapp.domain.model.PokemonDetailModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RequestDetailPokemonUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(namePokemon: String): Flow<PokemonDetailModel> {
        return repository.getDetailPokemonFromApi(namePokemon)
    }
}
