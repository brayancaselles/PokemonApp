package com.example.pokemonapp.ui.pokemondetail.adapters.statAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemStatBinding
import com.example.pokemonapp.domain.model.StatModel

class StatViewHolder(private val binding: ItemStatBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(stat: StatModel) = with(binding) {
        textStat.text = stat.nameStat.replaceFirstChar { it.uppercase() }
        textBaseStat.text = stat.baseStat
    }
}
