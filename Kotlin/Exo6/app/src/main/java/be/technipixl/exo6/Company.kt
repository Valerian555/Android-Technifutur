package be.technipixl.exo6

class Company(
    var name: String,
    var listeEmployées: MutableList<Employee>,
    var listClients: MutableList<Customer>,
    var address: Address
    ){
    override fun toString(): String {
        return "Company(name='$name', listeEmployées=$listeEmployées, listClients=$listClients, address=$address)"
    }
}