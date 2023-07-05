package be.technipixl.exo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import be.technipixl.exo1.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val addition = {a: Float,b: Float -> a+b}
    private val subtraction = { a: Float, b: Float -> a-b}
    private val multiplication = {a: Float,b: Float -> a*b}
    private val division = {a: Float,b: Float -> a/b}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onOperation(v: View?){
        try {
            val a = binding.firstValue.text.toString().toFloat()
            val b = binding.secondValue.text.toString().toFloat()
            binding.result.text = when (v) {
                binding.buttonAddition -> "${addition(a, b)}"
                binding.buttonSubstraction -> "${subtraction(a, b)}"
                binding.buttonMultiplication -> "${multiplication(a, b)}"
                binding.buttonDivide -> "${division(a, b)}"
                else -> "Error, not managed"
            }
        }catch (e: NumberFormatException){
            binding.result.text = "Invalid Input"
        }

    }

}

