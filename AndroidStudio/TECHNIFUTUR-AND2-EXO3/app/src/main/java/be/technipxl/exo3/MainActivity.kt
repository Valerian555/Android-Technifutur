 package be.technipxl.exo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

 class MainActivity : AppCompatActivity() {
    var mcuList = mutableListOf("Tony Stark", "Steve Rogers", "Bruce Banner",
        "Vision", "Loki", "Stephen Strange", "Peter Parker", "Natasha Romanoff",
        "Thor", "Nick Fury")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mcuList.add("Peter Quill")

        Log.d("MCU", mcuList.toString())

        mcuList.remove("Tony Stark")
        mcuList.remove("Steve Rogers")
        mcuList.remove("Vision")
        mcuList.remove("Loki")
        mcuList.remove("Natasha Romanoff")

        Log.d("MCU-AFTER END GAME", mcuList.toString())

        val mcuListSorted = mcuList.sorted()
        Log.d("MCU-sorted", mcuListSorted.toString())

        mcuListSorted.forEach {
            Log.d("MCU", "Name: $it")
        }

        //For in de 0 à la taille -1. Pas génial.
        for(index in 0..mcuListSorted.size - 1) {
            Log.d("MCU", "Index: $index Name: ${mcuList[index]}")
        }

        //For in avec le mot clé until. Déjà mieux.
        for(index in 0 until mcuListSorted.size) {
            Log.d("MCU", "Index: $index Name: ${mcuList[index]}")
        }

        //For in sur les indices. Encore mieux.
        for(index in mcuListSorted.indices) {
            Log.d("MCU", "Index: $index Name: ${mcuList[index]}")
        }

        //For withIndex. Voilà.
        for ((index, value) in mcuListSorted.withIndex()) {
            Log.d("MCU", "Index: $index Name: $value")
        }
    }
}