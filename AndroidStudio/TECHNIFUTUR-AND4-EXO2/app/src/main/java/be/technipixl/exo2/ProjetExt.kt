package be.technipixl.exo2

import android.util.Log

fun Personne.quit() {
    if(this.annualSalary <2500){
        Log.d("EXO10", "${this.name} quit")
    }
}