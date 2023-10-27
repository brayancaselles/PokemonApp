package com.example.pokemonapp.ui.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.data.toError
import com.example.pokemonapp.domain.usecase.RequestPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val requestPokemonListUseCase: RequestPokemonListUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow(UiStatePokemon())
    val state: StateFlow<UiStatePokemon> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            requestPokemonListUseCase().apply {
                catch { cause -> _state.update { it.copy(error = cause.toError()) } }
                    .collect { pokemonList ->
                        _state.update { it.copy(pokemonList = pokemonList, isLoading = false) }
                    }
            }
        }
    }

    fun getPokemonList() {
        viewModelScope.launch {
            requestPokemonListUseCase().catch { cause -> _state.update { it.copy(error = cause.toError()) } }
                .collect { pokemonList ->
                    _state.update { it.copy(pokemonList = pokemonList, isLoading = false) }
                }
        }
    }
}
