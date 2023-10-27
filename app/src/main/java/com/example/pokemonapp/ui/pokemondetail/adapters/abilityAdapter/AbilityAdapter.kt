package com.example.pokemonapp.ui.pokemondetail.adapters.abilityAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pokemonapp.data.basicDiffUtil
import com.example.pokemonapp.databinding.ItemAbilitiesBinding
import com.example.pokemonapp.domain.model.AbilityModel

class AbilityAdapter() :
    ListAdapter<AbilityModel, AbilityViewHolder>(basicDiffUtil { old, new -> old == new }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityViewHolder {
        return AbilityViewHolder(
            ItemAbilitiesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: AbilityViewHolder, position: Int) {
        val abilityItem = getItem(position)
        holder.bind(abilityItem)
    }
}
