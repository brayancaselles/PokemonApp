package com.example.pokemonapp.ui.pokemonlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.domain.model.PokemonModel

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun bind(pokemon: PokemonModel) = with(binding) {
        textNamePokemon.text = pokemon.name
    }
}
