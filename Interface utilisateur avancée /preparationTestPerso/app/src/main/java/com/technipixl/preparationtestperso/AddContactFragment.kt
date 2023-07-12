package com.technipixl.preparationtestperso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.preparationtestperso.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {
    private lateinit var binding: FragmentAddContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddContactBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelButton.setOnClickListener {
            //permet d'obtener la BackStackEntry du fragment précédent
            val savedStateHandle = findNavController().previousBackStackEntry?.savedStateHandle

            /*La constante FirstFragment.DETAIL_TEXT (qui est définie dans le premier fragment)
            est la clé pour stocker la valeur. La valeur est obtenue à partir du texte de l'editText.*/
            savedStateHandle?.set(ContactFragment.DETAIL_TEXT, Person(binding.firstName.text.toString(),binding.lastName.text.toString()))


            findNavController().navigateUp()
        }
    }


}