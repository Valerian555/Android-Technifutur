package com.technipixl.exo2

import android.graphics.Color
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo2.databinding.HomeCellLayoutBinding
import com.technipixl.exo2.models.Cryptos
import kotlin.math.roundToInt

class HomeCryptoViewHolder(private var viewBinding: HomeCellLayoutBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(crypto: Cryptos) {
            val roundedCrypto =
                ((crypto.changePercent24Hr?.toDouble())?.times(10))?.roundToInt()?.toDouble()
                    ?.div(10)

            if (roundedCrypto!! >= 0) {
                viewBinding.percentTextview.setTextColor(viewBinding.root.context.getColor(R.color.green))
            } else {
                viewBinding.percentTextview.setTextColor(viewBinding.root.context.getColor(R.color.red))
            }
            viewBinding.symboleTextview.text = crypto.symbol
            viewBinding.cryptoNameTextview.text = crypto.name
            viewBinding.percentTextview.text = "$roundedCrypto%"


        }
}