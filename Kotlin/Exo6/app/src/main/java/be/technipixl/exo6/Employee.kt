package be.technipixl.exo6

class Employee(
    var nom: String,
    var prenom: String,
    var address: Address? = null,
    var naissance: String? = null,
    var email: String = "employee@technipxl.com"
){
    override fun toString(): String {
        return "Employee(nom='$nom', prenom='$prenom', address=$address, naissance=$naissance, email='$email')"
    }
}