package com.example.pokemonapp.ui.pokemondetail.adapters.typeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pokemonapp.data.basicDiffUtil
import com.example.pokemonapp.databinding.ItemTypeBinding
import com.example.pokemonapp.domain.model.TypeModel

class TypeAdapter() :
    ListAdapter<TypeModel, TypeViewHolder>(basicDiffUtil { old, new -> old == new }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        return TypeViewHolder(
            ItemTypeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        val typeItem = getItem(position)
        holder.bind(typeItem)
    }
}
