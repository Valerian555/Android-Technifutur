package be.technipixl.exo9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = Pair(0,1)

        val seq = generateSequence(start, {Pair(it.second, it.first + it.second)})


        Log.d("EXO9", seq.elementAt(10).toString())
        Log.d("EXO9", seq.elementAt(26).toString())
    }
}