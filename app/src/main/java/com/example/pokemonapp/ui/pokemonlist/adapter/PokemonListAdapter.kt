package com.example.pokemonapp.ui.pokemonlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R

class PokemonListAdapter(private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(onClick)
    }
}
