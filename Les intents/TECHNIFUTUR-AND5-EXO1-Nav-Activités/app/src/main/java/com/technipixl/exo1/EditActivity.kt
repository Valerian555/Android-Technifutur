package com.technipixl.exo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.technipixl.exo1.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding

    companion object {
        const val DETAIL_REQUEST_CODE = 100
        const val DETAIL_EXTRA_ORIGINAL_NAME = "DETAIL_EXTRA_ORIGINAL_NAME"
        const val DETAIL_EXTRA_EDITED_NAME = "DETAIL_EXTRA_EDITED_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Cela permet de pré-remplir le champ de texte avec la valeur d'un nom précédemment enregistré
        binding.nameEditText.setText(intent.getStringExtra(DETAIL_EXTRA_ORIGINAL_NAME))
        setResult(RESULT_CANCELED)
    }

    fun save(view: View) {
        val firstName = binding.nameEditText.text.toString()
        if (!firstName.isNullOrEmpty()) {
            intent.putExtra(DETAIL_EXTRA_EDITED_NAME, firstName)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}