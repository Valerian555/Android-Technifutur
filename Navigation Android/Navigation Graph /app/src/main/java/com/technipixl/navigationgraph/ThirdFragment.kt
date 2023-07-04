package com.technipixl.navigationgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.navigationgraph.databinding.FragmentFirstBinding
import com.technipixl.navigationgraph.databinding.FragmentThirdBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ThirdFragment : Fragment() {
    lateinit var binding: FragmentThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toDetailFragmentButton.setOnClickListener{
            val direction = ThirdFragmentDirections.actionThirdFragmentToDetailFragment("")
            findNavController().navigate(direction)
        }

        binding.foodButton.setOnClickListener {
            val direction = ThirdFragmentDirections.actionThirdFragmentToDetailFragment("Food")
            findNavController().navigate(direction)
        }

        binding.musicButton.setOnClickListener {
            val direction = ThirdFragmentDirections.actionThirdFragmentToDetailFragment("Music")
            findNavController().navigate(direction)
        }

        binding.sportButton.setOnClickListener {
            val direction = ThirdFragmentDirections.actionThirdFragmentToDetailFragment("Sport")
            findNavController().navigate(direction)
        }
    }

}