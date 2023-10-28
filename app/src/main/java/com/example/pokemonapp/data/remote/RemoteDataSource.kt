package com.example.pokemonapp.data.remote

import com.example.pokemonapp.data.datasource.IRemoteDataSource
import com.example.pokemonapp.data.ifContainsKeyReturnString
import com.example.pokemonapp.data.remote.network.IApiService
import com.example.pokemonapp.domain.model.AbilityModel
import com.example.pokemonapp.domain.model.MoveModel
import com.example.pokemonapp.domain.model.PokemonDetailModel
import com.example.pokemonapp.domain.model.PokemonModel
import com.example.pokemonapp.domain.model.SpriteModel
import com.example.pokemonapp.domain.model.SpritesModel
import com.example.pokemonapp.domain.model.StatModel
import com.example.pokemonapp.domain.model.TypeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: IApiService) :
    IRemoteDataSource {

    override fun requestPokemonListFromApi(): Flow<List<PokemonModel>> {
        return flow {
            val apiResponse = apiService.fetchDataFromApi("generation/1/")

            val jsonObject = JSONObject(apiResponse)
            val listPokemon = parseDataPokemonListResponse(jsonObject)

            emit(listPokemon)
        }
    }

    private fun parseDataPokemonListResponse(responseObject: JSONObject): ArrayList<PokemonModel> {
        val pokemonList: ArrayList<PokemonModel> = arrayListOf()
        val response = responseObject.getJSONArray("pokemon_species")
        for (i in 0 until response.length()) {
            val pokemonSpeciesJson = response.getJSONObject(i)
            val pokemon = PokemonModel(
                name = pokemonSpeciesJson.getString("name") ?: "",
                url = pokemonSpeciesJson.getString("url") ?: "",
            )
            pokemonList.add(pokemon)
        }
        pokemonList.sortedBy { it.name }
        return pokemonList
    }

    override fun requestDetailPokemonFromApi(namePokemon: String): Flow<PokemonDetailModel> {
        return flow {
            val completeUrl = "pokemon/$namePokemon"
            val apiResponse = apiService.fetchDataFromApi(completeUrl)
            val responseObject = JSONObject(apiResponse)
            if (responseObject != null) {
                emit(parseDataDetail(responseObject))
            }
        }
    }

    private suspend fun parseDataDetail(responseJson: JSONObject): PokemonDetailModel {
        val name = if (responseJson.has("name")) responseJson.getString("name") ?: "" else ""

        val spritesJSONObject = responseJson.getJSONObject("sprites")
        val sprites = parseImagesSprites(spritesJSONObject)

        val typeJSONArray = responseJson.getJSONArray("types")
        val type = parseTypes(typeJSONArray)

        val abilitiesJson = responseJson.getJSONArray("abilities")
        val abilities = parseAbilities(abilitiesJson)

        val movesJson = responseJson.getJSONArray("moves")
        val moves = parseMoves(movesJson)

        val statsJson = responseJson.getJSONArray("stats")
        val stats = parseStats(statsJson)

        return PokemonDetailModel(name, sprites, type, abilities, moves, stats)
    }

    private suspend fun parseImagesSprites(spritesJSONObject: JSONObject): SpritesModel {
        val listImages = arrayListOf<String>()

        val backDefault = spritesJSONObject.ifContainsKeyReturnString("back_default")
        listImages.add(backDefault)

        val backFemale = spritesJSONObject.ifContainsKeyReturnString("back_female")
        listImages.add(backFemale)

        val backShiny = spritesJSONObject.ifContainsKeyReturnString("back_shiny")
        listImages.add(backShiny)

        val backShinyFemale = spritesJSONObject.ifContainsKeyReturnString("back_shiny_female")
        listImages.add(backShinyFemale)

        val frontDefault = spritesJSONObject.ifContainsKeyReturnString("front_default")
        listImages.add(frontDefault)

        val frontFemale = spritesJSONObject.ifContainsKeyReturnString("front_female")
        listImages.add(frontFemale)

        val frontShiny = spritesJSONObject.ifContainsKeyReturnString("front_shiny")
        listImages.add(frontShiny)

        val frontShinyFemale = spritesJSONObject.ifContainsKeyReturnString("front_shiny_female")
        listImages.add(frontShinyFemale)

        return downloadImages(listImages)
    }

    private suspend fun downloadImages(imageUrls: List<String>): SpritesModel {
        val spritesList: ArrayList<SpriteModel> = arrayListOf()
        val imagesBitmap = apiService.downloadImagesParallelFromApi(imageUrls)

        if (imagesBitmap.size >= 8) {
            imagesBitmap[4]?.let { SpriteModel(it) }?.let { spritesList.add(it) }
            imagesBitmap[5]?.let { SpriteModel(it) }?.let { spritesList.add(it) }

            for (i in imagesBitmap.indices) {
                val sprite = imagesBitmap[i]?.let { SpriteModel(it) }
                if (sprite != null && (i != 4 && i != 5)) {
                    spritesList.add(sprite)
                }
            }
        }

        return SpritesModel(spritesList)
    }

    private fun parseTypes(typesJson: JSONArray): List<TypeModel> {
        val typesList: ArrayList<TypeModel> = arrayListOf()

        for (i in 0 until typesJson.length()) {
            val typeObject = typesJson.getJSONObject(i).getJSONObject("type")
            val type = TypeModel(typeObject.getString("name") ?: "")
            typesList.add(type)
        }
        return typesList
    }

    private fun parseAbilities(abilitiesJson: JSONArray): List<AbilityModel> {
        val abilitiesList: ArrayList<AbilityModel> = arrayListOf()

        for (i in 0 until abilitiesJson.length()) {
            val abilityObject = abilitiesJson.getJSONObject(i).getJSONObject("ability")
            val ability = AbilityModel(abilityObject.getString("name") ?: "")
            abilitiesList.add(ability)
        }

        return abilitiesList
    }

    private fun parseMoves(movesJson: JSONArray): List<MoveModel> {
        val moveList: ArrayList<MoveModel> = arrayListOf()

        for (i in 0 until movesJson.length()) {
            val moveObject = movesJson.getJSONObject(i).getJSONObject("move")
            val move = MoveModel(moveObject.getString("name") ?: "")
            moveList.add(move)
        }

        return moveList
    }

    private fun parseStats(statsJson: JSONArray): List<StatModel> {
        val statsList: ArrayList<StatModel> = arrayListOf()

        for (i in 0 until statsJson.length()) {
            val baseStat = statsJson.getJSONObject(i).getString("base_stat")
            val statObject = statsJson.getJSONObject(i).getJSONObject("stat")
            val stat = StatModel(baseStat = baseStat, nameStat = statObject.getString("name") ?: "")
            statsList.add(stat)
        }

        return statsList
    }
}
