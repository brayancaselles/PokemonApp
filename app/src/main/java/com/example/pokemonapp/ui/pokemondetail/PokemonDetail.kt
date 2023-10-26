package com.example.pokemonapp.ui.pokemondetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pokemonapp.R
import com.example.pokemonapp.data.diff
import com.example.pokemonapp.data.setVisibleOrGone
import com.example.pokemonapp.databinding.PokemonDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonDetail : Fragment(R.layout.pokemon_detail_fragment) {

    private val viewModel: DetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = PokemonDetailFragmentBinding.bind(view).apply { }
        launchGetDetailPokemon(binding)
    }

    private fun launchGetDetailPokemon(binding: PokemonDetailFragmentBinding) {
        lifecycleScope.launch(Dispatchers.IO) {
            with(viewModel.state) {
                diff(this, { it.isLoading }) { binding.progressLoading.setVisibleOrGone(it) }
                diff(
                    this,
                    {
                        it.detailPokemon
                    },
                ) { pokemonDetail ->
                }
            }
        }
    }
}
