package com.technipixl.preparationtestperso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.preparationtestperso.databinding.FragmentAddContactBinding
import com.technipixl.preparationtestperso.databinding.FragmentContactBinding


class ContactFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding
    val personsList = mutableListOf<Person>(
        Person("Valérian", "Paillet"),
        Person("Laurent", "JesaisPLus"),
        Person("Tony", "Izzi"),
        Person("Medhi", "Habarru"),
        Person("Damon", "Jacquemin"),
        Person("Ludo", "Vostes"),
        Person("Raph", "JesaisPlus"),
        Person("Romane", "JesaisPlus"),
        Person("Duc", "Luu"),
    )

    //var qui permet de surveiller les changements de données et de réagir en conséquence
    private var liveData: MutableLiveData<Person>? = null

    //Constante utilisée pour définir une clé pour la récupération de données dans le SavedStateHandle.
    companion object {
        const val DETAIL_TEXT = "DETAIL_TEXT"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentContactBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        //permet de savoir l'écran/ou le fragment sur lequel on se trouve
        val currentBackStackEntry = findNavController().currentBackStackEntry

        val savedStateHandle = currentBackStackEntry?.savedStateHandle

        liveData= savedStateHandle?.getLiveData<Person>(DETAIL_TEXT)


        /*observe les changement de liveData, lorsque celle-ci change, la lambda est appelé.
        En résumé, lorsque un changement est appliqué sur liveData, la textView est mise à jour.*/
        liveData?.observe(viewLifecycleOwner) { info->
                personsList.add(info)
            }

        binding.addButton.setOnClickListener {
            val direction = ContactFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(direction)
        }
    }

    //on destroy l'Observer pour économiser les données
    override fun onDestroy() {
        liveData?.removeObservers(viewLifecycleOwner)
        super.onDestroy()
    }

    private fun setupRecyclerView() {
        //récupération du composant RecyclerView
        val recyclerView = binding?.recyclerView
        //defintion de son layout
        recyclerView?.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false)

        recyclerView?.adapter = PersonAdapter(personsList) {
            val direction = ContactFragmentDirections.actionFirstFragmentToInfoFragment()
            findNavController().navigate(direction)
        }
    }

}