package com.technipixl.preparationtestperso

import androidx.recyclerview.widget.RecyclerView
import com.technipixl.preparationtestperso.databinding.CellLayoutBinding

class PersonViewHolder(private var viewBinding: CellLayoutBinding, private val onClick: (Person) -> Unit) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(person: Person) {
        viewBinding.firstName.text = person.firstName
        viewBinding.lastName.text = person.lastName

        //permet de remonter l'info à l'adapter
        viewBinding.editButton.setOnClickListener {
            onClick(person)
        }
    }


}