package com.neopixl.navigationtechnifutur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.neopixl.navigationtechnifutur.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {

            //permet d'obtener la BackStackEntry du fragment précédent
            val savedStateHandle = findNavController().previousBackStackEntry?.savedStateHandle

            /*La constante FirstFragment.DETAIL_TEXT (qui est définie dans le premier fragment)
            est la clé pour stocker la valeur. La valeur est obtenue à partir du texte de l'editText.*/
            savedStateHandle?.set(FirstFragment.DETAIL_TEXT, binding.editText.text.toString())

            findNavController().navigateUp()
        }
    }
}