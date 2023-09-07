package com.technipixl.exo2.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo2.databinding.HomeCellLayoutBinding
import com.technipixl.exo2.network.model.Crypto
import com.technipixl.exo2.network.model.CryptoResponse

class CryptoHomeAdapter (private val cryptoResponse: CryptoResponse,
                         private val onItemClick: (Crypto) -> Unit):
    RecyclerView.Adapter<CryptoHomeViewHolder>() {
    private lateinit var binding: HomeCellLayoutBinding
    private val filteredList = mutableListOf<Crypto>()

    init {
        filteredList.addAll(cryptoResponse.data)
    }

    //responsable de la création de chaque cellule dans la recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoHomeViewHolder {
        return CryptoHomeViewHolder(
            HomeCellLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClick)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: CryptoHomeViewHolder, position: Int) {
        holder.setup(filteredList[position])
    }
}