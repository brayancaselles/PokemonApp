package com.example.pokemonapp.ui.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.usecase.RequestPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
            _state.value = UiStatePokemon(isLoading = true)
            val pokemonList = requestPokemonListUseCase()
            _state.update { _state.value.copy(isLoading = false, pokemonList = pokemonList) }
        }
    }
}
