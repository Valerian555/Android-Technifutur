package be.technipxl.exo6

class Company(
    var name: String,
    var employeesList: MutableList<Employee>? = null,
    var customersList: MutableList<Customer>? = null,
    var address: Address
) {
    override fun toString(): String {
        return "Company(name='$name', employeesList=$employeesList, customersList=$customersList, address=$address)"
    }
}