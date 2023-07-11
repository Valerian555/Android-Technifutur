package com.technipixl.exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.technipixl.exo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val languagesList= mutableListOf(
        Language("Swift"),
        Language("C++"),
        Language("Kotlin"),
        Language("Java"),
        Language("JavaScript"),
        Language("Cobole"),
        Language("Python")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
    }

    private fun setupSpinner() {
        with(binding.mySpinner){
            adapter = MySpinnerAdapter(languagesList)

            //pop up si on selectionne qq chose
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selectedItem = languagesList[position]
                    Toast.makeText(
                        context,"${selectedItem.name} selected",
                    Toast.LENGTH_SHORT).show()
                }

                //popup si rien n'est sélectionné
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(
                        context,
                        "Nothing selected",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}