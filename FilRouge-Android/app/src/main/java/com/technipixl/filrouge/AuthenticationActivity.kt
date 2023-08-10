package com.technipixl.filrouge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.contains
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import com.technipixl.filrouge.databinding.ActivityAuthentificationBinding

class AuthenticationActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthentificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthentificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun openHome(view: View) {
        val emailNotEmpty = binding.emailEditText.text.toString().isNotEmpty()
        val passwordNotEmpty = binding.passwordEditText.text.toString().isNotEmpty()

        if(emailNotEmpty && passwordNotEmpty){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}