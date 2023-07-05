package be.technipxl.exo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        add(10f,100f)
        substract(10f,100f)
        multiply(10f, 100f)
        divide(10f, 100f)

        divide(10f)
        divide(a = 10f)
        divide(b = 10f)

        printResult("addition", add(40f,60f))
    }

    fun add(a: Float = 0f, b: Float = 0f) = a+b
    fun substract(a: Float = 0f, b: Float = 0f) = a-b
    fun multiply(a: Float = 0f, b: Float = 0f) = a*b
    fun divide(a: Float = 0f, b: Float = 0f) = a/b

    fun printResult(operationName: String, result: Float) {
        Log.d("TAG", "$operationName : $result")
    }
}

