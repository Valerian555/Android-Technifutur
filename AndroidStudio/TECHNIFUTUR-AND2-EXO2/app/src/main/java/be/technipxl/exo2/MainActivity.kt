package be.technipxl.exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val mcuCharacters = mutableListOf<String>("Tony Stark","Peter Parker","Wanda Maximof","Stephen Strange", "Natasha Romanof","Gamora","Peter Quil","Bruce Banner","Loki","Thor")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mcuCharacters.add("Steve Rogers")

        Log.d("MCU", mcuCharacters.toString())

        mcuCharacters.remove("Tony Stark")
        mcuCharacters.remove("Loki")
        mcuCharacters.remove("Gamora")
        mcuCharacters.remove("Steve Rogers")
        mcuCharacters.remove("Natasha Romanof")

        Log.d("MCU after End game", mcuCharacters.toString())
        Log.d("MCU after End game", mcuCharacters.toString() )
    }
}