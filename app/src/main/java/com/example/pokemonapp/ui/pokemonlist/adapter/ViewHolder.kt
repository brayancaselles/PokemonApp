package com.example.pokemonapp.ui.pokemonlist.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.data.remote.network.Response.Pokemon
import com.example.pokemonapp.databinding.ItemPokemonBinding

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun bind(pokemon: Pokemon) = with(binding) {
        textNamePokemon.text = pokemon.name
    }

    /*private fun downloadImageUrl(imageUrl: String): Bitmap? {
        var bitmap: Bitmap? = null
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO) {
                try {
                    val url = URL(imageUrl)
                    val connection = url.openConnection() as HttpURLConnection
                    connection.doInput = true
                    connection.connect()
                    val input: InputStream = connection.inputStream
                    bitmap = BitmapFactory.decodeStream(input)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        Log.d("BITMAP ----->", "$bitmap")
        return bitmap
    }*/
}
