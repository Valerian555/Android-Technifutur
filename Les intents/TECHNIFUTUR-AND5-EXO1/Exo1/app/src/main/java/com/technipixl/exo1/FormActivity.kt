package com.technipixl.exo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.technipixl.exo1.databinding.ActivityFormBinding
import com.technipixl.exo1.databinding.ActivityMainBinding

class FormActivity : AppCompatActivity() {
    lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun OpenEditActivity(view: View){
        val intent = Intent(this,EditActivity::class.java)
        startActivity(intent)
    }
}