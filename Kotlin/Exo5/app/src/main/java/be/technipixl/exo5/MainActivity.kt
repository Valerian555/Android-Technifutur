package be.technipixl.exo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textResult = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.input_hour)
        val editText2 = findViewById<EditText>(R.id.input_name)
        val buttonDisplay = findViewById<Button>(R.id.button_display)

        buttonDisplay.setOnClickListener {
            val hour = editText.text.toString().toInt()
            val name = editText2.text.toString()

            textResult.text = helloMessageV2(hour, name)
        }

        for (i in 0..23){
            Log.d("V1 - $i", helloMessageV1(i,"Val").toString())
        }

        for (i in 0..23){
            Log.d("V2 - $i", helloMessageV2(i,"Val"))
        }

    }

    fun helloMessageV1(time: Int, name:String){
        if(time in 6..12){
            "Bonjour $name"
        } else if(time in 13..18 ){
            "Bonne après-midi $name"
        } else if(time in 19..22){
            "Bonne soirée $name"
        } else {
            "Bonne nuit $name"
        }
    }

    fun helloMessageV2(time: Int, name:String) = when(time) {
            in 6..12 -> "Bonjour $name!"
            in 13..18 -> "Bonne après-midi $name!"
            in 19..22 -> "Bonne soirée $name!"
            23, in 0..5 -> "Bonne nuit $name!"
            else  -> "Invalid Input"
        }
    }
