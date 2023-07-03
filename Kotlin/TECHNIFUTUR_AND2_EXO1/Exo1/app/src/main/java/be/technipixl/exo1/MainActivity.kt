package be.technipixl.exo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var firstName: String
    lateinit var lastName: String
    var age = 0
    val company:String = "Technifutur"

    override fun onCreate(savedInstanceState: Bundle?) {
        firstName = "John"
        lastName = "Doe"
        age = 30
        //companie = "Technifutur2" (pas possible de changer la valeur d'un "val")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}