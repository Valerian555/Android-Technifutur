package com.technipixl.onetomany.ui.authorList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.onetomany.databinding.FragmentAuthorsListBinding
import com.technipixl.onetomany.db.AuthorDatabase
import com.technipixl.onetomany.models.Author
import com.technipixl.onetomany.models.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AuthorsListFragment : Fragment() {
    private lateinit var binding: FragmentAuthorsListBinding
    var authorList = mutableListOf<Author>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorsListBinding.inflate(layoutInflater)

        var db = AuthorDatabase.getDb(requireContext())

        CoroutineScope(IO).launch {

            db.authorDao().getAll().collect {
                authorList.clear()
                authorList.addAll(it)
            }
        }
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        //récupération du composant RecyclerView
        val recyclerView = binding.authorRecylerview

        //defintion de son type d'affichage
        recyclerView?.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false)

        recyclerView?.adapter = AuthorAdapter(authorList) { author ->
            goToDetails(author.name, author.authorId)
        }
    }

    private fun goToDetails(authorName: String, authorId: Long) {
        findNavController().navigate(AuthorsListFragmentDirections.actionAuthorsListFragmentToAuthorDetailsFragment(authorName, authorId))
    }

    private fun initializeDb() {
        CoroutineScope(IO).launch {
            val db = AuthorDatabase.getDb(requireContext())
            val authorsWithBook = db.authorDao().getAuthorsWithBooks()

            if (authorsWithBook.isNullOrEmpty()) {

                db.authorDao().insert(Author(name = "JK Rowling"))
                db.bookDao().insert(Book(authorOfBookId = 1, name = "Harry Potter 1"))
                db.bookDao().insert(Book(authorOfBookId = 1, name = "Harry Potter 2"))
                db.bookDao().insert(Book(authorOfBookId = 1, name = "Harry Potter 3"))
                db.bookDao().insert(Book(authorOfBookId = 1, name = "Harry Potter 4"))
                db.bookDao().insert(Book(authorOfBookId = 1, name = "Harry Potter 5"))
                db.bookDao().insert(Book(authorOfBookId = 1, name = "Harry Potter 6"))
                db.bookDao().insert(Book(authorOfBookId = 1, name = "Harry Potter 7"))

                db.authorDao().insert(Author(name = "Victor Hugo"))
                db.bookDao().insert(Book(authorOfBookId = 2, name = "JSP"))

            }
        }
    }
}