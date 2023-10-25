package com.example.pokemonapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavGraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_graph)
    }
}
