package com.technipixl.exo2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo2.databinding.HomeCellLayoutBinding
import com.technipixl.exo2.models.CryptoResponse
import com.technipixl.exo2.models.Cryptos

class CryptoAdapter(private var cryptoList: MutableList<Cryptos>) :
    RecyclerView.Adapter<HomeCryptoViewHolder>() {
    private lateinit var binding: HomeCellLayoutBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeCryptoViewHolder {
        //charge le layout de la cellule
        binding = HomeCellLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeCryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeCryptoViewHolder, position: Int) {
        holder.bind(cryptoList[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return cryptoList.size
    }

}