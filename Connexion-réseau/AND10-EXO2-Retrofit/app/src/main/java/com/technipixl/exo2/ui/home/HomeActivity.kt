package com.technipixl.exo2.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.technipixl.exo2.R
import com.technipixl.exo2.databinding.ActivityHomeBinding
import com.technipixl.exo2.network.model.Crypto
import com.technipixl.exo2.network.model.CryptoResponse
import com.technipixl.exo2.network.service.CryptoServiceImpl
import com.technipixl.exo2.ui.details.DetailsActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val cryptoService by lazy { CryptoServiceImpl() }
    private var adapter: CryptoHomeAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrieveData()
    }

    private fun retrieveData() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = cryptoService.getCryptoList()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("test", "je recois les données")
                    response.body()?.let { body ->
                        setupRecyclerView(cryptoResponse = body)
                    }
                }
            }
        }
    }

    private fun setupRecyclerView(cryptoResponse: CryptoResponse) {
        binding.homeRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.homeRecyclerView.adapter = CryptoHomeAdapter(cryptoResponse) {
            crypto ->  goToDetail(crypto)
        }
    }

    private fun goToDetail(crypto: Crypto) {
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }
}