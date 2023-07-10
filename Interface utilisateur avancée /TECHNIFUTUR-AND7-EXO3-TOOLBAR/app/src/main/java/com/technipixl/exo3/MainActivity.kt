package com.technipixl.exo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.technipixl.exo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //lien de la toolbar custom avec l'activité
        val toolbar = binding.customToolbar
        setSupportActionBar(toolbar.mainToolbar)


    }

    fun openSettings(view: View) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

}