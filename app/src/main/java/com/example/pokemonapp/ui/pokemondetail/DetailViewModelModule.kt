package com.example.pokemonapp.ui.pokemondetail

import androidx.lifecycle.SavedStateHandle
import com.example.pokemonapp.data.di.UrlToSearch
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DetailViewModelModule {

    @Provides
    @ViewModelScoped
    @UrlToSearch
    fun provideUrlToSearch(savedStateHandle: SavedStateHandle) =
        PokemonDetailArgs.fromSavedStateHandle(savedStateHandle).urlSearch
}
