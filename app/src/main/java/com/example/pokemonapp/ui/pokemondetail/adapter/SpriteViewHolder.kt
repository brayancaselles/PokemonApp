package com.example.pokemonapp.ui.pokemondetail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemSpriteBinding
import com.example.pokemonapp.domain.model.SpriteModel

class SpriteViewHolder(private val binding: ItemSpriteBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(sprites: SpriteModel) = with(binding) {
        imageViewSprite.setImageBitmap(sprites.image)
    }
}
