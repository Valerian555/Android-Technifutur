package com.technipixl.exobonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.technipixl.exobonus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
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