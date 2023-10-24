package com.example.pokemonapp.ui.pokemonlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.data.remote.network.Response.Pokemon
import com.example.pokemonapp.databinding.ItemPokemonBinding

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun bind(,onClick: (String) -> Unit) {
    }
}
