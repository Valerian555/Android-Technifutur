package com.technipixl.tabletdev

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.tabletdev.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: VersionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)

        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {

        //récupération du composant RecyclerView
        val recyclerView = binding?.maRecyclerView

        //defintion de son type d'affichage
        recyclerView?.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false)

        adapter = VersionAdapter(versionList) { version ->
            goToDetail(version)
        }

        binding.maRecyclerView.adapter = adapter
    }

    private fun goToDetail(version: Version) {
        val isTabletLayout = resources.configuration.smallestScreenWidthDp >= 600
        var supportFragmentManager = parentFragmentManager

        if (isTabletLayout) {
            val fragmentDetails = DetailsFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.detail_container, fragmentDetails)
            transaction.commit()
        } else {
            val transaction = supportFragmentManager.beginTransaction()
            val fragmentDetails = DetailsFragment()
            transaction.replace(R.id.nav_host_fragment, fragmentDetails)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}