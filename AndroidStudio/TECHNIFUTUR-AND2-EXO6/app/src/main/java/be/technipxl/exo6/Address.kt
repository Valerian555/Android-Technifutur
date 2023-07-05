package be.technipxl.exo6

class Address(
    var country: String,
    var city: String,
    var street: String,
    var postalCode: Int
) {
    override fun toString(): String {
        return "Address(country='$country', city='$city', street='$street', postalCode=$postalCode)"
    }
}