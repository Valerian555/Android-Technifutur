package com.technipixl.exo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo2.databinding.FragmentHomeBinding
import com.technipixl.exo2.models.Cryptos
import com.technipixl.exo2.network.CryptoServiceImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var cryptosList: MutableList<Cryptos> = mutableListOf()
    private val cryptoServiceImpl by lazy { CryptoServiceImpl() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        getCryptoAsync()

    }

    private fun setupRecyclerView() {

        //récupération du composant RecyclerView
        val recyclerView = binding.homeRecyclerview

        //defintion de son layout
        recyclerView.layoutManager = GridLayoutManager(context, 2)


        recyclerView.adapter = CryptoAdapter(cryptosList)

    }

    private fun getCryptoAsync() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = cryptoServiceImpl.getCrypto()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            cryptosList.addAll(it.cryptos)
                            setupRecyclerView()
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
}