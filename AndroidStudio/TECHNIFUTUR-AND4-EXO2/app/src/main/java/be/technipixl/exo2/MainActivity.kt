package be.technipixl.exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val personneList = mutableListOf<Personne>(
        Personne(46,"Jean", 20000),
        Personne(25,"Michel", 23000),
        Personne(61,"Marc", 30000),
        Personne(64,"Albert", 59000),
        Personne(64,"Laurent", 57000),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //EXO2
        val associateByName = personneList.associateBy{it.name}
        Log.d("EXO2", associateByName.toString())

        //EXO3
        val filteredEmployees = personneList.filter { it.annualSalary < 30000 || it.annualSalary > 50000 }
        Log.d("EXO3", filteredEmployees.toString())

        //EXO4
        val groupBySalaryRange = personneList.groupBy {
            val nombreEntier = (it.annualSalary / 5000).toInt()
            "${nombreEntier*5000}-${(nombreEntier+1)*5000}"
        }
        Log.d("EXO4", groupBySalaryRange.toString())

        //EXO5
        val firstSalaryLess50000 = personneList.takeWhile { it.annualSalary < 50000 }
        Log.d("EXO5", firstSalaryLess50000.toString())

        //EXO6
        val firstMoreThan30k = personneList.first { it.annualSalary > 30000 }
        val lastLessThan50K = personneList.last { it.annualSalary < 50000 }
        Log.d("EXO6-1", firstMoreThan30k.toString())
        Log.d("EXO6-2", lastLessThan50K.toString())

        //EXO7
        val sortedBySalary = personneList.sortedBy { it.annualSalary }
        Log.d("EXO7", sortedBySalary.toString())
        val sortedByName = sortedBySalary.sortedBy { it.name }
        Log.d("EXO7", sortedByName.toString())

        //EXO8
        val minSalary = personneList.minByOrNull { it.annualSalary }
        Log.d("EXO8", minSalary.toString())
        val maxSalary = personneList.maxByOrNull { it.annualSalary }
        Log.d("EXO8", maxSalary.toString())

        //EX10
        personneList.forEach { it.quit() }

    }
}