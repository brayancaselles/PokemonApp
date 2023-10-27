package com.example.pokemonapp.ui.pokemondetail.adapters.typeAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemTypeBinding
import com.example.pokemonapp.domain.model.TypeModel

class TypeViewHolder(private val binding: ItemTypeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(type: TypeModel) = with(binding) {
        textType.text = type.nameTypes.replaceFirstChar { it.uppercase() }
    }
}
