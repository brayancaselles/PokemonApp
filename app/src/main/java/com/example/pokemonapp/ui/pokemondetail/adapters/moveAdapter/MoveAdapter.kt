package com.example.pokemonapp.ui.pokemondetail.adapters.moveAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pokemonapp.data.basicDiffUtil
import com.example.pokemonapp.databinding.ItemMoveBinding
import com.example.pokemonapp.domain.model.MoveModel

class MoveAdapter() :
    ListAdapter<MoveModel, MoveViewHolder>(basicDiffUtil { old, new -> old == new }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        return MoveViewHolder(
            ItemMoveBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {
        val moveItem = getItem(position)
        holder.bind(moveItem)
    }
}
