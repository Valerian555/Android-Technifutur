package com.technipixl.onetomany.ui.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.onetomany.databinding.FragmentAuthorDetailsBinding
import com.technipixl.onetomany.db.AuthorDatabase
import com.technipixl.onetomany.models.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AuthorDetailsFragment : Fragment() {
    private lateinit var binding: FragmentAuthorDetailsBinding
    private val args: AuthorDetailsFragmentArgs by navArgs()
    private var booksList = mutableListOf<Book>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorDetailsBinding.inflate(layoutInflater)

        binding.authorName.text = args.authorName

        val db = AuthorDatabase.getDb(requireContext())

        CoroutineScope(IO).launch {
            val authorWithBooks = db.authorDao().getAuthorsWithBooksById(args.authorId)
            booksList.addAll(authorWithBooks.books.toMutableList())
        }

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {

        //récupération du composant RecyclerView
        val recyclerView = binding.booksRecyclerview

        //defintion de son type d'affichage
        recyclerView?.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false
        )

        recyclerView?.adapter = BookAdapter(booksList)
    }
}