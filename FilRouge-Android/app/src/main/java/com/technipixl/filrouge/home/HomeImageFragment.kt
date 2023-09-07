package com.technipixl.filrouge.home

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.technipixl.filrouge.databinding.FragmentHomeBinding
import com.technipixl.filrouge.databinding.FragmentHomeImageBinding

class HomeImageFragment(private val picture: Int, val text: String) : Fragment() {
    lateinit var binding: FragmentHomeImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeImageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView.setImageResource(picture)
        binding.cardviewText.text = text
    }
}