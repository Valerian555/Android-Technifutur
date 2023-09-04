package com.technipixl.exo2

import android.content.Context.MODE_APPEND
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.technipixl.exo2.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val LOGIN_KEY = "login_key"
    private val PASSWORD_KEY = "password_key"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)

        // 4.Récupération des données settings
        val sharedPref: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(requireContext())
        val colorSettings = sharedPref.getString("color_key", "white")
        val titleSettings = sharedPref.getString("title_key", "Title")

        //5.Utilisation des données settings récuperées
        when (colorSettings) {
            "white" -> binding.loginContainer.setBackgroundColor(resources.getColor(R.color.white))
            "red" -> binding.loginContainer.setBackgroundColor(resources.getColor(R.color.red))
            "yellow" -> binding.loginContainer.setBackgroundColor(resources.getColor(R.color.yellow))
            "blue" -> binding.loginContainer.setBackgroundColor(resources.getColor(R.color.blue))
        }
        binding.titleText.text = titleSettings


        // 6.Sauvegarde des logins
        binding.loginButton.setOnClickListener {
            val userName = binding.loginText.text
            val password = binding.passwordText.text

            if (!userName.isNullOrBlank() && !password.isNullOrBlank()) {
                Toast.makeText(requireActivity(), "Login success", Toast.LENGTH_LONG).show()
                if (binding.saveCheckbox.isChecked) {
                    with(sharedPref.edit()) {
                        putString(LOGIN_KEY, userName.toString())
                        putString(PASSWORD_KEY, password.toString())
                        apply()
                    }
                }
            } else {
                Toast.makeText(requireActivity(), "Invalid login", Toast.LENGTH_LONG).show()
            }

            writeLogs()

        }

        // 7.Réafficher les logins enregistrés
        val userName = sharedPref.getString(LOGIN_KEY, "")
        val password = sharedPref.getString(PASSWORD_KEY, "")

        if (!userName.isNullOrBlank() && !password.isNullOrBlank()) {
            binding.loginText.setText(userName)
            binding.passwordText.setText(password)
            binding.saveCheckbox.isChecked = true
        }

        //navigation vers le fragment settings
        binding.settingsButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSettingsFragment())
        }

        //naviguer vers le fragment logs
        binding.logsButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToLogsFragment())
        }

        return binding.root
    }

    private fun writeLogs() {
        //8. Créer fichier logs.txt
        // 9. Sortir de l'activité principal
        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {
            }
            // 10. Ecrire dans le fichier logs.txt
            try {
                val ous: FileOutputStream = requireContext().openFileOutput("logs.txt", MODE_APPEND)
                val bw = BufferedWriter(OutputStreamWriter(ous))
                bw.write("Try to log" + System.getProperty("line.separator"))
                bw.close()
            } catch (e: Exception) {
                println("Exception : $e")
            }
        }
    }
}