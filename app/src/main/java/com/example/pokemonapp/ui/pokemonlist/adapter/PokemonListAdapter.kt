package com.example.pokemonapp.ui.pokemonlist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pokemonapp.R
import com.example.pokemonapp.data.basicDiffUtil
import com.example.pokemonapp.data.inflate
import com.example.pokemonapp.data.remote.network.Response.Pokemon

class PokemonListAdapter(private val onClick: (Pokemon) -> Unit) :
    ListAdapter<Pokemon, ViewHolder>(basicDiffUtil { old, new -> old.name == new.name }) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val view = parent.inflate(R.layout.item_pokemon, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemonItem = getItem(position)
        holder.bind(pokemonItem)
        holder.itemView.setOnClickListener { onClick(pokemonItem) }
    }
}
