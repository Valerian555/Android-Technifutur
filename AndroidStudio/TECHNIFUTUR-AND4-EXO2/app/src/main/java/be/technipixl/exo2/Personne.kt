package be.technipixl.exo2

class Personne (
    val age: Int, val name: String, val annualSalary: Int
        ){
    override fun toString(): String {
        return "Personne(age=$age, name='$name', annualSalary=$annualSalary)"
    }
}

