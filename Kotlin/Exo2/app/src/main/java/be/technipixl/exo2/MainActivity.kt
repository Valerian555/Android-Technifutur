package be.technipixl.exo2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mcuCharacters = mutableListOf("Tony Stark","Star Lord","Captain America","Wanda","Vision","Doctor Strange", "Black Panther", "Hulk", "Thor")
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val buttonReset = findViewById<Button>(R.id.button_reset)
        val layout = findViewById<LinearLayout>(R.id.Linear_layout)

        fun displayList(){
            layout.removeAllViews()
            for (char in mcuCharacters) {
                val tv = TextView(this)
                tv.text = char
                mcuCharacters.indexOf(char)
                layout.addView(tv)}
        }

        button1.setOnClickListener {
            mcuCharacters.add("Loki")
            displayList()
        }

        button2.setOnClickListener {
            mcuCharacters.remove("Tony Stark")
            displayList()
        }

        button3.setOnClickListener {
            mcuCharacters = mcuCharacters.sorted().toMutableList()
            displayList()
        }

        button4.setOnClickListener {
            layout.removeAllViews()
            for (char in mcuCharacters) {
                val tv = TextView(this)
                tv.text = "name: $char"
                mcuCharacters.indexOf(char)
                layout.addView(tv)}
        }



        buttonReset.setOnClickListener {
            mcuCharacters = mutableListOf("Tony Stark","Star Lord","Captain America","Wanda","Vision","Doctor Strange", "Black Panther", "Hulk", "Thor")
            displayList()
        }


        Log.d("MCU", mcuCharacters.toString())
        Log.d("MCU after endGame", mcuCharacters.toString())
        Log.d("MCU", mcuCharacters.sorted().toString())

        fun add(a:Float,b:Float):Float{
            return a+b
        }
        fun substract(a:Float,b:Float):Float{
            return a-b
        }
        fun multiply(a:Float,b:Float):Float{
            return a*b
        }
        fun divide(a:Float,b:Float):Float{
            return a/b
        }


    }
}
