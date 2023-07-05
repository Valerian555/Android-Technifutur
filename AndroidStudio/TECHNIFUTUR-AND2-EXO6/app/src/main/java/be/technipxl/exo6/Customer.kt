package be.technipxl.exo6

class Customer(
    var firstName: String,
    var lastName: String,
    var address: Address
) {
    override fun toString(): String {
        return "Customer(firstName='$firstName', lastName='$lastName', address=$address)"
    }
}