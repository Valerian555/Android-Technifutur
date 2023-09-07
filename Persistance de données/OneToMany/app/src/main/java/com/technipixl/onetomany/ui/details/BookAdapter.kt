package com.technipixl.onetomany.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.onetomany.databinding.BookCellBinding
import com.technipixl.onetomany.models.Book

class BookAdapter(private val books: MutableList<Book>)
    : RecyclerView.Adapter<BookViewHolder>() {
    private lateinit var binding: BookCellBinding
    //responsable de la création de chaque cellule dans la recyclerView
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {
        binding = BookCellBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.setup(books[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return books.size
    }
}