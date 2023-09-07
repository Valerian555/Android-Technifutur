package com.technipixl.onetomany.ui.authorList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.onetomany.databinding.AuthorCellBinding
import com.technipixl.onetomany.models.Author

class AuthorAdapter(private val author: MutableList<Author>,
    private val onItemClick: (Author) -> Unit)
    : RecyclerView.Adapter<AuthorViewHolder>() {
    private lateinit var binding: AuthorCellBinding

    //responsable de la création de chaque cellule dans la recyclerView
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AuthorViewHolder {
        binding = AuthorCellBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AuthorViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        holder.setup(author[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return author.size
    }
}