package be.technipixl.exo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textResult = findViewById<TextView>(R.id.textView)

        fun add(a: Float = 0f, b: Float = 0f) = a + b
        fun substract(a: Float = 0f, b: Float = 0f) = a - b
        fun multiply(a: Float = 0f, b: Float = 0f) = a * b
        fun divide(a: Float = 0f, b: Float = 0f) = a / b

        fun printResult(operationName:String, result:Float) = Log.d(operationName, result.toString())


        Log.d("Exo4-Add", add(10f, 100f).toString())
        Log.d("Exo4-substract", substract(10f, 100f).toString())
        Log.d("Exo4-multiply", multiply(10f, 100f).toString())
        Log.d("Exo4-divide", divide(10f, 100f).toString())

        divide(10f)
        divide(a = 10f)
        divide(b = 10f)

        printResult("Exo4-printResult", add(5f,2f))

        val editText = findViewById<EditText>(R.id.firstNumber)
        val editText2 = findViewById<EditText>(R.id.secondNumber)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubstract = findViewById<Button>(R.id.buttonSubstract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)

        buttonAdd.setOnClickListener {
            val firstNumber = editText.text.toString().toFloat()
            val secondNumber = editText2.text.toString().toFloat()

            textResult.text = add(firstNumber,secondNumber).toString()
        }

        buttonSubstract.setOnClickListener {
            val firstNumber = editText.text.toString().toFloat()
            val secondNumber = editText2.text.toString().toFloat()

            textResult.text = substract(firstNumber, secondNumber).toString()
        }

        buttonMultiply.setOnClickListener {
            val firstNumber = editText.text.toString().toFloat()
            val secondNumber = editText2.text.toString().toFloat()

            textResult.text = multiply(firstNumber, secondNumber).toString()
        }

        buttonDivide.setOnClickListener {
            val firstNumber = editText.text.toString().toFloat()
            val secondNumber = editText2.text.toString().toFloat()
            textResult.text = divide(firstNumber, secondNumber).toString()
        }
    }
}