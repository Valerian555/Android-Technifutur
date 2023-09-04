package com.technipixl.exo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.technipixl.exo2.databinding.FragmentLogsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class LogsFragment : Fragment() {
    private lateinit var binding: FragmentLogsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogsBinding.inflate(layoutInflater)

        readLogs()

        return binding.root
    }

    //11. Récupérer en lecture les données dans le fichier
    private fun readLogs() {
        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {
                try {
                    val ins: FileInputStream = requireContext().openFileInput("logs.txt")
                    val reader = BufferedReader(InputStreamReader(ins))
                    var line: String?
                    val logsList =
                        mutableListOf<String>() // Utilisez une liste pour stocker les lignes
                    while (reader.readLine().also { line = it } != null) {
                        logsList.add(line.toString())
                    }
                    reader.close()

                    val logsListConcatened = logsList.joinToString("\n")
                    //retourner dans le mainThread pour changer l'UI
                    CoroutineScope(Dispatchers.Main).launch {
                        binding.logsTextview.text = logsListConcatened
                    }
                } catch (e: Exception) {
                    println("Exception : $e")
                }
            }
        }
    }
}