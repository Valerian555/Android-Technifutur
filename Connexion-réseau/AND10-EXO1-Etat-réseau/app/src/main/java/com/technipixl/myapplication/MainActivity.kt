package com.technipixl.myapplication

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technipixl.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //vérifie l'état du réseau lors du lancement de l'app
        if (isNetworkAvailable()) {
            binding.networkStateTextview.text = "AVAILABLE"
        } else if (!isNetworkAvailable()) {
            binding.networkStateTextview.text = "LOST"
        }

        //écoute le changement d'état
        registerForNetworkStateChanges()
    }


    private fun isNetworkAvailable(): Boolean {
        //récupération de l'instance
        val connectivityManager =
            getSystemService(ConnectivityManager::class.java)

        //vérification des capacités réseau
        val currentNetwork = connectivityManager.activeNetwork
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(currentNetwork)

        //vérification de la dispo des types de transports
        return networkCapabilities?.run {
            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        } ?: false
    }

    private fun registerForNetworkStateChanges() {
        val connectivityManager =
            getSystemService(ConnectivityManager::class.java)
        connectivityManager.registerDefaultNetworkCallback(object :
            ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                MainScope().launch {
                    binding.networkStateTextview.text = "AVAILABLE"
                }
            }

            override fun onLost(network: Network) {
                MainScope().launch {
                    binding.networkStateTextview.text = "LOST"
                }
            }
        })
    }
}