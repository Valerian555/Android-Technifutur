package com.technipixl.exo4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.technipixl.exo4.database.AppDatabase
import com.technipixl.exo4.database.MovieRepository
import com.technipixl.exo4.databinding.FragmentMovieListBinding
import com.technipixl.exo4.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListFragment : Fragment() {
    private lateinit var binding: FragmentMovieListBinding
    var moviesList = mutableListOf<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(layoutInflater)

        //gestion de la toolbar
        binding.listToolbar.title = "Movies List"

        //navigation de la toolbar
        binding.listToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_add_button -> {
                    findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToAddMovieFragment())
                    true
                }

                else -> false
            }
        }

        loadMoviesFromDatabase()

        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        //récupération du composant RecyclerView
        val recyclerView = binding.moviesRecyclerview

        //defintion de son type d'affichage
        recyclerView?.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false
        )

        recyclerView?.adapter = MovieAdapter(moviesList)
    }

    //6. Initialiser la bd
    private fun loadMoviesFromDatabase() {
        MovieRepository.initializeDB()

        MovieRepository.getAllMovies().observeForever {
            moviesList.removeAll(it)
            //TO DO it.filter { it }
            moviesList.addAll(it)
            binding.moviesRecyclerview.adapter?.notifyDataSetChanged()
        }
    }
}
