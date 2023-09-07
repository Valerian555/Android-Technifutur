package com.technipixl.filrouge.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.technipixl.filrouge.databinding.FragmentHomeBinding
import com.technipixl.filrouge.home.HomeGalleryPageAdapter


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
    }

    private fun setupViewPager() {
        val pagerAdapter = HomeGalleryPageAdapter(requireActivity())
        binding.homeViewpager.adapter = pagerAdapter

        TabLayoutMediator(binding.homeTabLayout, binding.homeViewpager) {tab, position ->}.attach()

    }
}