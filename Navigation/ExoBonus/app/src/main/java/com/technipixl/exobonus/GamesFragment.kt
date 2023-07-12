package com.technipixl.exobonus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.technipixl.exobonus.databinding.FragmentGamesBinding
import com.technipixl.exobonus.databinding.FragmentMovieBinding

class GamesFragment : Fragment() {
    private lateinit var binding: FragmentGamesBinding
    val types = TypeOfGames.values()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGamesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        for(type in types){
            val button = Button(context)
            button.setText(type.name)
            binding.gamesTypeContainer.addView(button)

            button.setOnClickListener {
                findNavController().navigate(GamesFragmentDirections.actionGamesFragmentToListGamesFragment(type))
            }
        }
    }

}