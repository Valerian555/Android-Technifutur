package com.technipixl.exo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    //création de la liste
    val heroesList = mutableListOf<Heroes>(
        Heroes("Iron Man", "Tony Stark", "Décedé"),
        Heroes("Docteur Stranger", "Stephen Strange", "Disparu"),
        Heroes("SpiderMan", "Peter Parker", "Oublié"),
        Heroes("Captain America", "Steve Rogers", "Décédé"),
        Heroes("Hulk", "Bruce Banner", "Père"),
        Heroes("Black Panther", "T'chala", "Remplacé"),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        //récupération du composant RecyclerView
        val recyclerView = binding?.marvelRecyclerView

        //defintion de son layout
        recyclerView?.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false)

        recyclerView?.adapter = HeroAdapter(heroesList.sortedBy {
            it.heroName
        }.toMutableList())
    }
}