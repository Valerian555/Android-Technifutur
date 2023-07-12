package com.technipixl.navfragmentsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.navfragmentsexample.databinding.FragmentCorrectBinding
import com.technipixl.navfragmentsexample.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
lateinit var binding: FragmentQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.yesbutton.setOnClickListener {
            val direction = QuestionFragmentDirections.actionQuestionFragmentToWrongFragment()
            findNavController().navigate(direction)
        }

        binding.nobutton.setOnClickListener {
            val direction = QuestionFragmentDirections.actionQuestionFragmentToCorrectFragment()
            findNavController().navigate(direction)
        }
    }


}