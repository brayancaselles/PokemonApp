package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.data.repository.Repository
import com.example.pokemonapp.domain.model.PokemonModel
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
class RequestPokemonListUseCaseTest {
    @Mock
    private lateinit var repository: Repository

    private lateinit var useCase: RequestPokemonListUseCase

    private val flowPokemon = flowOf(
        listOf(
            PokemonModel(
                name = "Pikachu",
                url = "url1",
            ),
        ),
    )

    @Before
    fun setUp() {
        useCase = RequestPokemonListUseCase(repository)
    }

    @Test
    fun `verify requestPokemonListFromApi is called when RequestPokemonListUseCase is invoked`() {

        useCase.invoke()

        verify(repository).requestPokemonListFromApi()
    }

    @Test
    fun `when RequestPokemonListUseCase is invoked should return pokemonFlow`() {

        whenever(repository.requestPokemonListFromApi()).thenReturn(flowPokemon)

        val pokemonFlow = useCase.invoke()

        assertEquals(flowPokemon, pokemonFlow)
    }
}
