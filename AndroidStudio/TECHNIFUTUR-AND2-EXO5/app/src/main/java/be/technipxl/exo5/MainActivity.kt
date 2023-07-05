package be.technipxl.exo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..23){
            Log.d("hour: $i", displayGreetings(i, "Valérian"))
        }
    }
}

fun displayGreetings(hour: Int, name: String): String{
    when(hour){
        in 6..12 -> {
            return "Bonjour $name"
        }
        in 13..18 -> {
            return "Bonne après midi $name"
        }
        in 19..22 -> {
            return "Bonne soirée $name"
        }
        in 0..5, 23 -> {
            return "Bonne nuit $name"
        }
    }
}