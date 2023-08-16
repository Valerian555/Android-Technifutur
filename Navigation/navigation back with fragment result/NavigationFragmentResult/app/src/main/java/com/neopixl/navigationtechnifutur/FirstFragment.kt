package com.neopixl.navigationtechnifutur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.neopixl.navigationtechnifutur.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    
    companion object {
        const val FRAGMENT_RESULT = "FRAGMENT_RESULT"
        const val STRING_RESULT = "STRING_RESULT"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(FRAGMENT_RESULT) { key, bundle ->
            val stringResult = bundle.getString(STRING_RESULT)
            binding.textView.text = stringResult
        }

        binding.detailButton.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
        }
    }
}