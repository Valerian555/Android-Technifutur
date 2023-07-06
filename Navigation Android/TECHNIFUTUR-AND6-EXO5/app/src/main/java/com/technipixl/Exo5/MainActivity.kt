package com.technipixl.Exo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.technipixl.Exo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.navHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

}