package com.example.pokemonapp.domain.model

import android.graphics.Bitmap

data class SpritesModel(
    val backDefault: Bitmap? = null,
    val backFemale: Bitmap? = null,
    val backShiny: Bitmap? = null,
    val backShinyFemale: Bitmap? = null,
    val frontDefault: Bitmap? = null,
    val frontFemale: Bitmap? = null,
    val frontShiny: Bitmap? = null,
    val frontShinyFemale: Bitmap? = null,
)
