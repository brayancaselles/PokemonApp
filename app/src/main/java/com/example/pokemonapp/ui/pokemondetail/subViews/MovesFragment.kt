package com.example.pokemonapp.ui.pokemondetail.subViews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.MovesFragmentBinding
import com.example.pokemonapp.domain.model.MoveModel
import com.example.pokemonapp.ui.pokemondetail.adapters.moveAdapter.MoveAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovesFragment(private val moves: List<MoveModel>) : Fragment(R.layout.moves_fragment) {

    private val moveAdapter = MoveAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = MovesFragmentBinding.bind(view)
        initAdapter(binding)
    }

    private fun initAdapter(binding: MovesFragmentBinding) {
        with(binding) {
            recyclerViewMove.adapter = moveAdapter
            moveAdapter.submitList(moves)
        }
    }
}
