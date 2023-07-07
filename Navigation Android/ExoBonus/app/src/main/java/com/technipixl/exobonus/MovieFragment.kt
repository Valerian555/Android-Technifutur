package com.technipixl.exobonus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.technipixl.exobonus.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {
    private lateinit var binding: FragmentMovieBinding
    val genres = MovieGenre.values()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        for(genre in genres){
            val button = Button(context)
            button.setText(genre.name)
            binding.genreContainer.addView(button)

            button.setOnClickListener {
                findNavController().navigate(MovieFragmentDirections.actionMoviesFragmentToListMoviesFragment(genre))
            }
        }
    }
}