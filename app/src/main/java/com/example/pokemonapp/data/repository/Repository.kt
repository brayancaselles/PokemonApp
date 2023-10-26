package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.datasource.ILocalDataSource
import com.example.pokemonapp.data.datasource.IRemoteDataSource
import com.example.pokemonapp.domain.model.PokemonDetailModel
import com.example.pokemonapp.domain.model.PokemonModel
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource,
) {

    val pokemonList get() = localDataSource.pokemonList

    suspend fun getPokemonListFromApi(): List<PokemonModel>? {
        return if (localDataSource.isEmpty()) {
            val pokemonList: ArrayList<PokemonModel> = ArrayList()
            val result = remoteDataSource.getPokemonListFromApi()

            if (result != null) {
                for (i in 0 until result.length()) {
                    val jsonObject = result.getJSONObject(i)
                    val pokemon = PokemonModel(
                        name = jsonObject.getString("name"),
                        url = jsonObject.getString("url"),
                    )
                    pokemonList.add(pokemon)
                }
            }
            pokemonList.sortedBy { it.name }
        } else {
            null
        }
    }

    suspend fun getDetailPokemonFromApi(namePokemon: String): List<PokemonDetailModel>? {
        val result = remoteDataSource.getDetailPokemonFromApi(namePokemon)
        return null
    }
}
