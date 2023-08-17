package com.technipixl.exo2.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.technipixl.exo2.R
import com.technipixl.exo2.databinding.ActivityHomeBinding
import com.technipixl.exo2.network.model.CryptoResponse
import com.technipixl.exo2.network.service.CryptoServiceImpl
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
                try {
                    if (response.isSuccessful) {
                        response.body()?.let { body ->
                            setupRecyclerView(cryptoResponse = body)
                            Log.d("test", "je recois les données")
                        }
                    }
                } catch (e: HttpException) {
                    print(e)
                } catch (e: Throwable) {
                    print(e)
                }
            }
        }
    }

    private fun setupRecyclerView(cryptoResponse: CryptoResponse) {
        binding.homeRecyclerView.layoutManager = GridLayoutManager(this, 2)

    }
}