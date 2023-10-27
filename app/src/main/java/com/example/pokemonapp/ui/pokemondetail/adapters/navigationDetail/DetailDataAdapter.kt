package com.example.pokemonapp.ui.pokemondetail.adapters.navigationDetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokemonapp.domain.model.PokemonDetailModel
import com.example.pokemonapp.ui.pokemondetail.subViews.AbilitiesFragment
import com.example.pokemonapp.ui.pokemondetail.subViews.MovesFragment
import com.example.pokemonapp.ui.pokemondetail.subViews.StatsFragment
import com.example.pokemonapp.ui.pokemondetail.subViews.TypesFragment

class DetailDataAdapter(
    fragment: FragmentManager,
    lifecycle: Lifecycle,
    private val pokemonDetail: PokemonDetailModel,
) :
    FragmentStateAdapter(fragment, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TypesFragment(pokemonDetail.types)
            1 -> AbilitiesFragment(pokemonDetail.abilities)
            2 -> MovesFragment(pokemonDetail.moves)
            else -> StatsFragment(pokemonDetail.stats)
        }
    }
}
