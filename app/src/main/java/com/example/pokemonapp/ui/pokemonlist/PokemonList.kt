package com.example.pokemonapp.ui.pokemonlist

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.pokemonapp.R
import com.example.pokemonapp.data.diff
import com.example.pokemonapp.data.remote.network.Response.Pokemon
import com.example.pokemonapp.data.setVisibleOrGone
import com.example.pokemonapp.databinding.PokemonListFragmentBinding
import com.example.pokemonapp.ui.pokemonlist.adapter.PokemonListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonList : Fragment(R.layout.pokemon_list_fragment) {

    private val viewModel: PokemonListViewModel by viewModels()

    private val adapter = PokemonListAdapter { onPokemonClick(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = PokemonListFragmentBinding.bind(view)
            .apply { recyclerViewPokemonList.adapter = adapter }
        launchGetPokemonList(binding)
    }

    private fun launchGetPokemonList(binding: PokemonListFragmentBinding) {
        lifecycleScope.launch(Dispatchers.IO) {
            with(viewModel.state) {
                diff(this, { it.isLoading }) { binding.progressLoading.setVisibleOrGone(it) }
                diff(
                    this,
                    {
                        it.pokemonList
                    },
                ) { pokemonList ->
                    adapter.submitList(pokemonList)
                    initTextFilter(binding, pokemonList)
                }
            }
        }
    }

    private fun onPokemonClick(pokemon: Pokemon) {
        val action = PokemonListDirections.actionPokemonListToPokemonDetail(pokemon.url)
        findNavController().navigate(action)
    }

    private fun initTextFilter(binding: PokemonListFragmentBinding, pokemonList: List<Pokemon>?) {
        binding.textViewSearch.addTextChangedListener { text ->

            val filter = pokemonList?.filter { textFilter ->
                textFilter.name.lowercase().contains(text.toString().lowercase())
            }
            adapter.submitList(filter)
        }
    }
}
