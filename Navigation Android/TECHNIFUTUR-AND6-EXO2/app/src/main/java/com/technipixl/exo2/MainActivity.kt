package com.technipixl.exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE","onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE","onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE","onDestroy")
    }
}