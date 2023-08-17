package com.technipixl.exo2.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo2.databinding.HomeCellLayoutBinding
import com.technipixl.exo2.network.model.Crypto
import com.technipixl.exo2.network.model.CryptoResponse

class CryptoHomeAdapter (private val cryptoResponse: CryptoResponse):
    RecyclerView.Adapter<CryptoHomeViewHolder>() {
    private lateinit var binding: HomeCellLayoutBinding
    private val filteredList = mutableListOf<Crypto>()

    init {
        filteredList.addAll(cryptoResponse.cryptoList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoHomeViewHolder {
        //charge le layout de la cellule
        binding = HomeCellLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoHomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: CryptoHomeViewHolder, position: Int) {
        holder.setup(filteredList[position])
    }


}