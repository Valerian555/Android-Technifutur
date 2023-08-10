package com.technipixl.filrouge

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.contains
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.technipixl.filrouge.databinding.ActivityAuthentificationBinding
import java.util.regex.Pattern

class AuthenticationActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthentificationBinding

    private var emailValid: Boolean = false
    private var passwordValid: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthentificationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //binding.emailInputLayout.isErrorEnabled
        //binding.emailInputLayout.error = "Error"
    }

    override fun onStart() {
        super.onStart()

        binding.emailEditText.doAfterTextChanged {
            if(binding.emailEditText.text.toString().matches(android.util.Patterns.EMAIL_ADDRESS.toRegex())) {
                binding.emailInputLayout.isErrorEnabled = false
                emailValid = true
                binding.emailEditText.setTextColor(getColor(R.color.green))
            } else {
                emailValid = false
                binding.emailInputLayout.isErrorEnabled = true
                binding.emailInputLayout.error = "L'email n'est pas valide"
                binding.emailEditText.setTextColor(getColor(R.color.red))
            }
        }

        binding.passwordEditText.doAfterTextChanged {
            if(binding.passwordEditText.text.toString().matches(Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$").toRegex())) {
                binding.passwordInputLayout.isErrorEnabled = false
                passwordValid = true
                binding.passwordEditText.setTextColor(getColor(R.color.green))
            } else {
                passwordValid = false
                binding.passwordInputLayout.isErrorEnabled = true
                binding.passwordInputLayout.error = "Le mot de passe n'est pas valide"
                binding.passwordEditText.setTextColor(getColor(R.color.red))
            }
        }
    }

    fun openHome(view: View) {
        val emailNotEmpty = binding.emailEditText.text.toString().isNotEmpty()
        val passwordNotEmpty = binding.passwordEditText.text.toString().isNotEmpty()

        if(passwordValid && emailValid){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}