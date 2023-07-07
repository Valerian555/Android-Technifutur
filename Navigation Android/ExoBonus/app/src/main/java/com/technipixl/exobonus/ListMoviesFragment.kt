package com.technipixl.exobonus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.technipixl.exobonus.databinding.FragmentListMoviesBinding
import com.technipixl.exobonus.databinding.FragmentMovieBinding

class ListMoviesFragment : Fragment() {
    private lateinit var binding: FragmentListMoviesBinding
    private val args: ListMoviesFragmentArgs by navArgs()
    val listOfMovies = mutableListOf<Movies>()

    init {
        listOfMovies.add(Movies("The Dark Knight - Le Chevalier noir",
            "Avec l'appui du lieutenant de police Jim Gordon et du procureur de Gotham, Harvey Dent, Batman vise à éradiquer le crime organisé qui pullule dans la ville.",
        MovieGenre.ACTION))
        listOfMovies.add(Movies("Mad Max - Fury Road",
            "Max est capturé et fait prisonnier dans la Citadelle dirigée par Immortan Joe. C’est alors qu'il se retrouve embarqué dans une course poursuite explosive.",
            MovieGenre.ACTION))
        listOfMovies.add(Movies("Shining",
            "Écrivain, Jack Torrance est engagé comme gardien, pendant tout l’hiver, d’un grand hôtel isolé du Colorado, l’Overlook, où il espère surmonter enfin sa panne d’inspiration.",
        MovieGenre.HORREUR))
        listOfMovies.add(Movies("Conjuring - Les Dossiers Warren",
        "Harrisville, un couple d'experts en phénomènes paranormaux interviennent dans une maison hantée et décident de chasser ces esprits maléfiques.",
        MovieGenre.HORREUR))
        listOfMovies.add(Movies("Le Seigneur des Anneaux - La Communauté de l'anneau", "Le jeune hobbit Frodon Sacquet hérite d'un anneau. Il s'agit de l'Anneau Unique, instrument de pouvoir absolu qui permettrait à Sauron, de régner sur la Terre du Milieu et de réduire en esclavage ses peuples...",
        MovieGenre.FANTASTIQUE))
        listOfMovies.add(Movies("Harry Potter à l'école des sorciers","Orphelin, Harry Potter est élevé par son oncle et sa tante qui l'obligent à vivre dans un placard. Ces derniers, lui cachent qu'il est en fait fils de sorciers et que sa place est à Poudlard, la prestigieuse école de magie.",
        MovieGenre.FANTASTIQUE))
        listOfMovies.add(Movies("Shutter Island",
        "En 1954, une des patientes de l'hôpital psychiatrique situé sur l'île de Shutter Island, au large de Boston, a disparu sans laisser de traces.",
        MovieGenre.THRILLER))
        listOfMovies.add(Movies("Zodiac",
            "En 1969, un tueur en série sème la terreur à San Francisco. Revendiquant pas moins de trente-sept meurtres, ce mystérieux meurtrier prend un malin plaisir à narguer la police en envoyant des lettres codées à la presse.",
            MovieGenre.THRILLER))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListMoviesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listOfMovies.filter {
            it.genre == args.genre
        }.forEach {movie ->
            val button = Button(context)
            button.setText(movie.name)
            binding.moviesListContainer.addView(button)

            button.setOnClickListener {
                findNavController().navigate(ListMoviesFragmentDirections.actionListMoviesFragmentToDescriptionFragment(movie.name, movie.description))
            }

        }
    }


}