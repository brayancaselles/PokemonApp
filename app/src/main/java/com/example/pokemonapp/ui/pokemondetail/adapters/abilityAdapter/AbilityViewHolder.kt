package com.example.pokemonapp.ui.pokemondetail.adapters.abilityAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemAbilitiesBinding
import com.example.pokemonapp.domain.model.AbilityModel

class AbilityViewHolder(private val binding: ItemAbilitiesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(abilities: AbilityModel) = with(binding) {
        textAbility.text = abilities.nameAbility.replaceFirstChar { it.uppercase() }
    }
}
