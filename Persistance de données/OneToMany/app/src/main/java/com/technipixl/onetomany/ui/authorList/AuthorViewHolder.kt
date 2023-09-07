package com.technipixl.onetomany.ui.authorList

import androidx.recyclerview.widget.RecyclerView
import com.technipixl.onetomany.databinding.AuthorCellBinding
import com.technipixl.onetomany.models.Author

class AuthorViewHolder(private var binding: AuthorCellBinding,
private val onItemClick: (Author) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun setup(author: Author) {
        binding.authorName.text = author.name

        binding.container.setOnClickListener {
            onItemClick(author)
        }
    }
}