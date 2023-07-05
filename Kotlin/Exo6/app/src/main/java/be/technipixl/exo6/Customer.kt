package be.technipixl.exo6

class Customer(
    var nom: String,
    var address: Address
    ){
    override fun toString(): String {
        return "Customer(nom='$nom', address=$address)"
    }
}