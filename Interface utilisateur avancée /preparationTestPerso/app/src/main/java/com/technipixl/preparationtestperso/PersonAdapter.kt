package com.technipixl.preparationtestperso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.preparationtestperso.databinding.CellLayoutBinding

class PersonAdapter(private var persons: MutableList<Person>, private val onClick: (Person) -> Unit)
    : RecyclerView.Adapter<PersonViewHolder>() {
    private lateinit var binding: CellLayoutBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonViewHolder {
        //charge le layout de la cellule
        binding = CellLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(persons[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return persons.size
    }
}