package com.example.pokemonapp.ui.pokemondetail.adapters.spriteAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pokemonapp.data.basicDiffUtil
import com.example.pokemonapp.databinding.ItemSpriteBinding
import com.example.pokemonapp.domain.model.SpriteModel

class SpriteAdapter() :
    ListAdapter<SpriteModel, SpriteViewHolder>(basicDiffUtil { old, new -> old == new }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpriteViewHolder {
        return SpriteViewHolder(
            ItemSpriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: SpriteViewHolder, position: Int) {
        val spriteItem = getItem(position)
        holder.bind(spriteItem)
    }
}
