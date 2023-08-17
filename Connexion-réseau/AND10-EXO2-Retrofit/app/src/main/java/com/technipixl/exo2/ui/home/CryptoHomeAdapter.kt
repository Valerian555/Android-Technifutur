package com.technipixl.exo2.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo2.databinding.HomeCellLayoutBinding
import com.technipixl.exo2.network.models.Cryptos
import kotlin.math.roundToInt

class CryptoHomeAdapter(private var cryptoList: MutableList<Cryptos>) :
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
        holder.setup(cryptoList[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return cryptoList.size
    }

    var sortedList = cryptoList

    fun sortedPositiveItem() {
        cryptoList = sortedList.filter { ((it.changePercent24Hr?.toDouble())?.times(10))?.roundToInt()?.toDouble()
            ?.div(10)!! >= 0 }.toMutableList()

        cryptoList.sortedByDescending { it.changePercent24Hr?.toDouble() }
        notifyDataSetChanged()
    }

    fun sortedNegativeItem() {
        cryptoList = sortedList.filter {((it.changePercent24Hr?.toDouble())?.times(10))?.roundToInt()?.toDouble()
            ?.div(10)!! < 0 }.toMutableList()
        notifyDataSetChanged()
    }

    fun cancelFilter() {
        cryptoList = sortedList
        notifyDataSetChanged()
    }
}