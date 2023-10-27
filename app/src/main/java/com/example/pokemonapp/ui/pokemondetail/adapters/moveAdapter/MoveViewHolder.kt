package com.example.pokemonapp.ui.pokemondetail.adapters.moveAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemMoveBinding
import com.example.pokemonapp.domain.model.MoveModel

class MoveViewHolder(private val binding: ItemMoveBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(move: MoveModel) = with(binding) {
        textMove.text = move.nameMove.replaceFirstChar { it.uppercase() }
    }
}
