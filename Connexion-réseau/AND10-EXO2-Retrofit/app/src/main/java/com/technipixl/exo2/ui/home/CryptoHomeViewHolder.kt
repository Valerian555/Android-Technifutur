package com.technipixl.exo2.ui.home

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo2.R
import com.technipixl.exo2.databinding.HomeCellLayoutBinding
import com.technipixl.exo2.network.model.Crypto

class CryptoHomeViewHolder(
    private val binding: HomeCellLayoutBinding,
    //fonction lambda qui prend un objet de type Crypto en tant qu'argument et ne renvoie rien (Unit)
    private val onItemClick: (Crypto) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    val context = binding.root.context
    fun setup(crypto: Crypto) {
        binding.nameTextview.text = crypto.name
        binding.symbolTextview.text = crypto.symbol

        //arrondir et ajouter pourcentage
        val formattedPercentage = String.format("%.2f", crypto.toPercent())
        binding.percentlTextview.text = "$formattedPercentage%"

        //colour du pourcentage en fonction de sa valeur
        val color = when {
            crypto.toPercent() > 0 -> ContextCompat.getColor(context, R.color.positive_text)
            crypto.toPercent() < 0 -> ContextCompat.getColor(context, R.color.negative_text)
            else -> Color.BLACK
        }
        binding.percentlTextview.setTextColor(color)

        //configuré un clic sur la cellule
        binding.container.setOnClickListener {
            onItemClick(crypto)
        }
    }
}