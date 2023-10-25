package com.example.pokemonapp.ui.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.usecase.RequestPokemonListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonListViewModel(private val requestPokemonListUseCase: RequestPokemonListUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
        }
    }

    fun getPokemonList() {
        viewModelScope.launch {
            _state.value = UiState(isLoading = true)
            val pokemonList = requestPokemonListUseCase.invoke()
            _state.update { _state.value.copy(isLoading = false, pokemonList = pokemonList) }
        }
    }
}
