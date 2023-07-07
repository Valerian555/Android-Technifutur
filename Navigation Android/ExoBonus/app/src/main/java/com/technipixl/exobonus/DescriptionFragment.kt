package com.technipixl.exobonus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.technipixl.exobonus.databinding.FragmentDescriptionBinding
import com.technipixl.exobonus.databinding.FragmentListGamesBinding

class DescriptionFragment : Fragment() {
    private lateinit var binding: FragmentDescriptionBinding
    private val args: DescriptionFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDescriptionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleDescription.setText(args.title)
        binding.descriptionDescription.setText(args.description)
    }
}
