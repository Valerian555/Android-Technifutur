package com.technipixl.onetomany.ui.details

import androidx.recyclerview.widget.RecyclerView
import com.technipixl.onetomany.databinding.BookCellBinding
import com.technipixl.onetomany.models.Book

class BookViewHolder(private var binding: BookCellBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setup(book: Book) {
        binding.bookName.text = book.name
    }
}