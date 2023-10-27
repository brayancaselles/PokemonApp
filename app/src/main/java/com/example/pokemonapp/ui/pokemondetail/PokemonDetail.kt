package com.example.pokemonapp.ui.pokemondetail

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.pokemonapp.R
import com.example.pokemonapp.data.diff
import com.example.pokemonapp.data.setVisibleOrGone
import com.example.pokemonapp.databinding.PokemonDetailFragmentBinding
import com.example.pokemonapp.ui.pokemondetail.adapter.SpriteAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.abs

@AndroidEntryPoint
class PokemonDetail : Fragment(R.layout.pokemon_detail_fragment) {

    private val viewModel: DetailViewModel by viewModels()
    private val adapterSprite = SpriteAdapter()
    private lateinit var sliderHandler: Handler
    private lateinit var sliderRun: Runnable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = PokemonDetailFragmentBinding.bind(view).apply {
            containerToolbar.iconBack.setOnClickListener {
                findNavController().popBackStack()
            }
            viewPagerSprites.apply {
                clipToPadding = false
                clipChildren = false
                getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                adapter = adapterSprite
            }
            setSlider(this)
        }
        launchGetDetailPokemon(binding)
    }

    private fun launchGetDetailPokemon(binding: PokemonDetailFragmentBinding) {
        lifecycleScope.launch(Dispatchers.IO) {
            with(viewModel.state) {
                diff(this, { it.isLoading }) { binding.progressLoading.setVisibleOrGone(it) }
                diff(this, { it.detailPokemon }) { pokemonDetail ->
                    binding.textViewNamePokemon.text =
                        pokemonDetail?.name?.replaceFirstChar { it.uppercase() }
                    adapterSprite.submitList(pokemonDetail?.sprites?.spriteList)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRun, 3000)
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRun)
    }

    private fun setSlider(binding: PokemonDetailFragmentBinding) {
        val comPosPageTrans = CompositePageTransformer()
        comPosPageTrans.addTransformer(MarginPageTransformer(40))
        comPosPageTrans.addTransformer { page, position ->
            val r: Float = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        with(binding.viewPagerSprites) {
            setPageTransformer(comPosPageTrans)
            sliderHandler = Handler()
            sliderRun = Runnable {
                currentItem += 1
            }
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    sliderHandler.removeCallbacks(sliderRun)
                    sliderHandler.postDelayed(sliderRun, 3000)
                }
            })
        }
    }
}
