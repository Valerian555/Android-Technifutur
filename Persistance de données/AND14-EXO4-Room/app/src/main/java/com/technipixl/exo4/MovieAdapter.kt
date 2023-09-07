package com.technipixl.exo4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo4.databinding.MoviesListCellBinding
import com.technipixl.exo4.models.Movie

class MovieAdapter(private val movies: MutableList<Movie>)
    : RecyclerView.Adapter<MovieViewHolder>() {
    private lateinit var binding: MoviesListCellBinding

    //responsable de la création de chaque cellule dans la recyclerView
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        binding = MoviesListCellBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setup(movies[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return movies.size
    }
}