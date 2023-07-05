package be.technipxl.exo6

class Employee(
    var firstName: String,
    var lastName: String,
    var address: Address,
    var birthDate: String,
    var email: String
) {
    override fun toString(): String {
        return "Employee(firstName='$firstName', lastName='$lastName', address=$address, birthDate='$birthDate', email='$email')"
    }
}