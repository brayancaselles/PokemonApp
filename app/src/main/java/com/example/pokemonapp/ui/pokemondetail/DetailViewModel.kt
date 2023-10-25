package com.example.pokemonapp.ui.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.pokemonapp.data.di.UrlToSearch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(@UrlToSearch private val urlSearch: String) :
    ViewModel() {
    // TODO: Implement the ViewModel
}
