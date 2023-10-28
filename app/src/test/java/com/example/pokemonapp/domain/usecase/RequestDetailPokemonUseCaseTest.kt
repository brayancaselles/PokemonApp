package com.example.pokemonapp.domain.usecase

import com.example.pokemonapp.data.repository.Repository
import com.example.pokemonapp.domain.model.PokemonDetailModel
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
class RequestDetailPokemonUseCaseTest {

    @Mock
    private lateinit var repository: Repository

    private lateinit var useCase: RequestDetailPokemonUseCase

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
        useCase = RequestDetailPokemonUseCase(repository)
    }

    @Test
    fun `verify requestDetailPokemonFromApi is called when RequestDetailPokemonUseCase is invoked`() {

        useCase.invoke(namePokemon)

        verify(repository).requestDetailPokemonFromApi(namePokemon)
    }

    @Test
    fun `when RequestDetailPokemonUseCase is invoked should return detailFlow`() {

        whenever(repository.requestDetailPokemonFromApi(namePokemon)).thenReturn(flowDetailPokemon)

        val detailPokemonFlow = useCase.invoke(namePokemon)

        assertEquals(flowDetailPokemon, detailPokemonFlow)
    }
}
