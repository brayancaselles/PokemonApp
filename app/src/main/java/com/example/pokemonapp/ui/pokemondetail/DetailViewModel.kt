package com.example.pokemonapp.ui.pokemondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.data.di.NamePokemon
import com.example.pokemonapp.domain.usecase.RequestDetailPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    @NamePokemon private val urlSearch: String,
    private val requestDetailUseCase: RequestDetailPokemonUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(UiStateDetailPokemon())
    val state: StateFlow<UiStateDetailPokemon> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiStateDetailPokemon(isLoading = true)
            val detailPokemon = requestDetailUseCase(urlSearch)
            _state.update { _state.value.copy(isLoading = false, detailPokemon = detailPokemon) }
        }
    }
}
