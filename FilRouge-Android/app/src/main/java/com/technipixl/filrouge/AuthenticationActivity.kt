package com.technipixl.filrouge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.technipixl.filrouge.databinding.ActivityAuthentificationBinding
import java.util.regex.Pattern

class AuthenticationActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthentificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthentificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.background = getDrawable(R.drawable.disabled_button)
        binding.loginButton.isEnabled = false
    }

    override fun onStart() {
        super.onStart()

        updateTextField(binding.emailInputLayout, binding.emailEditText, "L'email n'est pas valide")
        updateTextField(
            binding.passwordInputLayout,
            binding.passwordEditText,
            "Le mot de passe n'est pas valide"
        )

    }

    fun openHome(view: View) {
        if (isValid(binding.emailEditText) && isValid(binding.passwordEditText)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun isValid(editText: EditText): Boolean {
        return if (editText == binding.emailEditText) {
            editText.text.toString().matches(android.util.Patterns.EMAIL_ADDRESS.toRegex())
        } else {
            editText.text.toString().matches(
                Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
                    .toRegex()
            )
        }
    }

    fun updateTextField(textLayout: TextInputLayout, editText: EditText, errorMessage: String) {
        editText.doAfterTextChanged {
            if (isValid(editText)) {
                textLayout.isErrorEnabled = false
                editText.setTextColor(getColor(R.color.green))
            } else {
                textLayout.isErrorEnabled = true
                textLayout.error = errorMessage
                editText.setTextColor(getColor(R.color.red))
            }

            updateButton()
        }
    }

    fun updateButton() {
        if (isValid(binding.emailEditText) && isValid(binding.passwordEditText)) {
            binding.loginButton.background = getDrawable(R.drawable.input_rounded_green_button)
            binding.loginButton.isEnabled = true
        } else {
            binding.loginButton.background = getDrawable(R.drawable.disabled_button)
            binding.loginButton.isEnabled = false
        }
    }
}