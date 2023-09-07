package com.technipixl.exo4

import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo4.databinding.MoviesListCellBinding
import com.technipixl.exo4.models.Movie

class MovieViewHolder(private var binding: MoviesListCellBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun setup(movie: Movie) {
        binding.movieName.text = movie.movieTitle
        binding.movieDuration.text = movie.movieDuration.toString()
        binding.movieDirector.text = movie.movieDirector
    }
}