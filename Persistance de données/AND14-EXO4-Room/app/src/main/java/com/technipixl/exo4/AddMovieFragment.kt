package com.technipixl.exo4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.exo4.database.MovieRepository
import com.technipixl.exo4.databinding.FragmentAddMovieBinding
import com.technipixl.exo4.models.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AddMovieFragment : Fragment() {
    private lateinit var binding: FragmentAddMovieBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddMovieBinding.inflate(layoutInflater)

        //gestion de la toolbar
        binding.addToolbar.title = "Add movie"

        //navigation de la toolbar
        binding.addToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_save_button-> {

                    findNavController().navigateUp()
                    true
                }
                else -> false
            }
        }

        return binding.root
    }



}