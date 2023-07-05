package be.technipxl.exo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var firstName: String
    lateinit var lastName: String
    var age: Int = 0
    val company: String = "Technifutur"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstName = "Jean"
        lastName = "Dupont"
        age = 30
        //company = "Technifutur2" (On ne peux pas réassigner une val)
    }
}