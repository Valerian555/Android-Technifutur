package be.technipixl.exo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var technipxl = Company(name="Technipxl",
            address= Address("Belgique","Liège","Rue du Bois St-Jean, 8", 4000),
            listClients = mutableListOf(),
            listeEmployées = mutableListOf())

        technipxl.listClients.add(Customer("Jean", Address("Belgique","Liège","Rue du Bois St-Jean 8", 4000)))
        technipxl.listClients.add(Customer("Marc", Address("Belgique","Liège","Rue du Bois St-Jean 10", 4000)))

        technipxl.listeEmployées.add(Employee("Dupont","Vincent",
            Address("Belgique","Liège","Rue du Bois St-Jean 11", 4000),
            "05/05/1999","VincentDupont@gmail.com"))

        Log.d("company", technipxl.toString())
    }
}