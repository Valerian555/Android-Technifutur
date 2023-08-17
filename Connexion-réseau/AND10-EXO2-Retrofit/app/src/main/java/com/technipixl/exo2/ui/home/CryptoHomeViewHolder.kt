package com.technipixl.exo2.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo2.databinding.HomeCellLayoutBinding
import com.technipixl.exo2.network.model.Crypto

class CryptoHomeViewHolder(private val binding: HomeCellLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun setup (crypto: Crypto) {
        binding.nameTextview.text = crypto.name
        binding.symbolTextview.text = crypto.symbol

        val formattedPercentage = String.format("%.2f", crypto.toPercent())
        binding.percentlTextview.text = formattedPercentage

    }
}