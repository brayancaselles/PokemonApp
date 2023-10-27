package com.example.pokemonapp.ui.pokemondetail.subViews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.AbilitiesFragmentBinding
import com.example.pokemonapp.domain.model.AbilityModel
import com.example.pokemonapp.ui.pokemondetail.adapters.abilityAdapter.AbilityAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AbilitiesFragment(private val abilities: List<AbilityModel>) :
    Fragment(R.layout.abilities_fragment) {

    private val abilityAdapter = AbilityAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = AbilitiesFragmentBinding.bind(view)
        initAdapter(binding)
    }

    private fun initAdapter(binding: AbilitiesFragmentBinding) {
        binding.recyclerViewAbility.adapter = abilityAdapter
        abilityAdapter.submitList(abilities)
    }
}
