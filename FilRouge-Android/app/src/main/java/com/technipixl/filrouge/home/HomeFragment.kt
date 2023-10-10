package com.technipixl.filrouge.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
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
        val fragments = mutableListOf<Fragment>()
        val pagerAdapter = HomeGalleryPageAdapter(requireContext(), childFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments)

        binding.homeViewpager.clipToPadding = false
        binding.homeViewpager.setPadding(120, 0, 120, 0)

        binding.homeViewpager.adapter = pagerAdapter

    }
}