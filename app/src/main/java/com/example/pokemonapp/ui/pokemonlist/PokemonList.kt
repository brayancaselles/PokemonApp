package com.example.pokemonapp.ui.pokemonlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.PokemonListFragmentBinding
import com.example.pokemonapp.ui.pokemonlist.adapter.PokemonListAdapter

class PokemonList : Fragment(R.layout.pokemon_list_fragment) {

    private val viewModel: PokemonListViewModel by viewModels()

    private val adapter = PokemonListAdapter { onPokemonClick(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = PokemonListFragmentBinding.bind(view)
            .apply { recyclerViewPokemonList.adapter = adapter }
        // with()
        viewModel.getPokemonList()
    }

    private fun onPokemonClick(namePokemon: String) {
    }
}
