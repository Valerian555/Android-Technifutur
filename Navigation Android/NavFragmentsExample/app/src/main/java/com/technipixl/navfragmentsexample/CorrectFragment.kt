package com.technipixl.navfragmentsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.navfragmentsexample.databinding.FragmentCorrectBinding
import com.technipixl.navfragmentsexample.databinding.FragmentQuestionBinding

class CorrectFragment : Fragment() {
    lateinit var binding: FragmentCorrectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCorrectBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tryagain.setOnClickListener {
            val direction = CorrectFragmentDirections.actionCorrectFragmentToQuestionFragment()
            findNavController().navigate(direction)
        }
    }
}