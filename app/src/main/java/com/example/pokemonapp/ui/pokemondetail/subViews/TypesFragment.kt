package com.example.pokemonapp.ui.pokemondetail.subViews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.TypesFragmentBinding
import com.example.pokemonapp.domain.model.TypeModel
import com.example.pokemonapp.ui.pokemondetail.adapters.typeAdapter.TypeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TypesFragment(private val types: List<TypeModel>) :
    Fragment(R.layout.types_fragment) {

    private val adapterType = TypeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = TypesFragmentBinding.bind(view)
        initAdapter(binding)
    }

    private fun initAdapter(binding: TypesFragmentBinding) {
        with(binding) {
            recyclerViewType.adapter = adapterType
            adapterType.submitList(types)
        }
    }
}
