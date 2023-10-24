package com.example.pokemonapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val url = "https://pokeapi.co/api/v2/pokemon/"
        CoroutineScope(Job() + Dispatchers.IO).launch {
            val apiService = ApiService()
            val controller = Controller(apiService)

            val result = controller.fetchData(url)
            if (result != null) {
                print("respuesta de la api $result")
            } else {
                println("error en la api")
            }
        }*/
    }
}
