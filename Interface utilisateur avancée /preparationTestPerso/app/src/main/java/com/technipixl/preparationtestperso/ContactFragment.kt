package com.technipixl.preparationtestperso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding.addButton.setOnClickListener {
            val direction = ContactFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(direction)
        }
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