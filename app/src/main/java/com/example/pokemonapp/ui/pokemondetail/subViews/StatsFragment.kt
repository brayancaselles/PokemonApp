package com.example.pokemonapp.ui.pokemondetail.subViews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.StatsFragmentBinding
import com.example.pokemonapp.domain.model.StatModel
import com.example.pokemonapp.ui.pokemondetail.adapters.statAdapter.StatAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsFragment(private val stats: List<StatModel>) : Fragment(R.layout.stats_fragment) {

    private val statAdapter = StatAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = StatsFragmentBinding.bind(view)
        initAdapter(binding)
    }

    private fun initAdapter(binding: StatsFragmentBinding) {
        with(binding) {
            recyclerViewStat.adapter = statAdapter
            statAdapter.submitList(stats)
        }
    }
}
