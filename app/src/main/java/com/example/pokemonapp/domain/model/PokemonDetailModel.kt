package com.example.pokemonapp.domain.model

data class PokemonDetailModel(
    val name: String,
    val sprites: SpritesModel,
    val types: List<TypeModel>,
    val abilities: List<AbilityModel>,
    val moves: List<MoveModel>,
    val stats: List<StatModel>,
)
