package com.example.pokemonapp.ui.pokemondetail.adapters.statAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pokemonapp.data.basicDiffUtil
import com.example.pokemonapp.databinding.ItemStatBinding
import com.example.pokemonapp.domain.model.StatModel

class StatAdapter() :
    ListAdapter<StatModel, StatViewHolder>(basicDiffUtil { old, new -> old == new }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatViewHolder {
        return StatViewHolder(
            ItemStatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: StatViewHolder, position: Int) {
        val statItem = getItem(position)
        holder.bind(statItem)
    }
}
