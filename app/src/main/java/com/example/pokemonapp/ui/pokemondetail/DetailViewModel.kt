package com.example.pokemonapp.ui.pokemondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.data.di.NamePokemon
import com.example.pokemonapp.data.toError
import com.example.pokemonapp.domain.usecase.RequestDetailPokemonUseCase
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
class DetailViewModel @Inject constructor(
    @NamePokemon private val urlSearch: String,
    private val requestDetailUseCase: RequestDetailPokemonUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(UiStateDetailPokemon())
    val state: StateFlow<UiStateDetailPokemon> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            requestDetailUseCase(urlSearch).catch { cause -> _state.update { it.copy(error = cause.toError()) } }
                .collect { detailPokemon ->
                    _state.update {
                        it.copy(
                            detailPokemon = detailPokemon,
                            isLoading = false,
                        )
                    }
                }
        }
    }

    fun getDetailPokemon() {
        viewModelScope.launch {
            requestDetailUseCase(urlSearch).catch { cause -> _state.update { it.copy(error = cause.toError()) } }
                .collect { detailPokemon ->
                    _state.update {
                        it.copy(
                            detailPokemon = detailPokemon,
                            isLoading = false,
                        )
                    }
                }
        }
    }
}
