package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.datasource.IRemoteDataSource
import com.example.pokemonapp.domain.model.PokemonDetailModel
import com.example.pokemonapp.domain.model.PokemonModel
import com.example.pokemonapp.domain.model.SpritesModel
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {

    @Mock
    private lateinit var remoteDataSource: IRemoteDataSource

    private lateinit var repository: Repository

    private val flowPokemon = flowOf(
        listOf(
            PokemonModel(
                name = "Pikachu",
                url = "url1",
            ),
        ),
    )

    private val namePokemon = "Pikachu"

    private val flowDetailPokemon = flowOf(
        PokemonDetailModel(
            namePokemon,
            SpritesModel(arrayListOf()),
            listOf(),
            listOf(),
            listOf(),
            listOf(),
        ),
    )

    @Before
    fun setup() {
        repository = Repository(remoteDataSource)
    }

    @Test
    fun `verify requestPokemonListFromApi is called when Repository is invoked`() {
        repository.requestPokemonListFromApi()

        verify(remoteDataSource).requestPokemonListFromApi()
    }

    @Test
    fun `given pokemon name when requestPokemonListFromApi is called then return a flow of list PokemonModel`() {
        whenever(repository.requestPokemonListFromApi()).thenReturn(flowPokemon)

        val listPokemonModel = repository.requestPokemonListFromApi()

        assertEquals(flowPokemon, listPokemonModel)
    }

    @Test
    fun `verify requestDetailPokemonFromApi is called when Repository is invoked`() {
        repository.requestDetailPokemonFromApi(namePokemon)

        verify(remoteDataSource).requestDetailPokemonFromApi(namePokemon)
    }

    @Test
    fun `given pokemon name when requestDetailPokemonFromApi is called then return a flow of PokemonDetailModel`() {
        whenever(repository.requestDetailPokemonFromApi(namePokemon)).thenReturn(flowDetailPokemon)

        val pokemonDetailModel = repository.requestDetailPokemonFromApi(namePokemon)

        assertEquals(flowDetailPokemon, pokemonDetailModel)
    }
}
