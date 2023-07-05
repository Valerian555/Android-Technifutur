package be.technipixl.exo6

class Address(
    var pays: String,
    var ville: String,
    var rue: String,
    var codePostal: Int
    ){
    override fun toString(): String {
        return "Address(pays='$pays', ville='$ville', rue='$rue', codePostal=$codePostal)"
    }
}