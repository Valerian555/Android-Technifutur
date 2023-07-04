package com.technipixl.navigationgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.navigationgraph.databinding.ActivityMainBinding
import com.technipixl.navigationgraph.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goSecondFragment.setOnClickListener{
            val direction = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(direction)
        }

        binding.goThirdFragmentButton.setOnClickListener{
            val direction = FirstFragmentDirections.actionFirstFragmentToThirdFragment()
            findNavController().navigate(direction)
        }

    }
}