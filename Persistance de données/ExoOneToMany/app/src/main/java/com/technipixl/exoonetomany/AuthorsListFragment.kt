package com.technipixl.exoonetomany

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.room.Database
import androidx.room.Room
import com.technipixl.exoonetomany.database.AuthorDatabase
import com.technipixl.exoonetomany.databinding.FragmentAuthorsListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthorsListFragment : Fragment() {
    private lateinit var binding: FragmentAuthorsListBinding
    lateinit var db: AuthorDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorsListBinding.inflate(layoutInflater)

        db = Room.databaseBuilder(requireActivity(), AuthorDatabase::class.java, "myDatabase.db")
            .build()

        return binding.root
    }

    }


