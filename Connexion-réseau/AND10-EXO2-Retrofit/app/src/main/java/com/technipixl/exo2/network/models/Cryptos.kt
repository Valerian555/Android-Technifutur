package com.technipixl.exo2.network.models

import com.google.gson.annotations.SerializedName

//modèle correspondant à une crypto et ses paramètres
data class Cryptos(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("symbol")
    var symbol: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("changePercent24Hr")
    var changePercent24Hr: String? = null,
)


//modèle correspondant à la collection de crypto
data class CryptoResponse(
    @SerializedName("data")
    var cryptos: MutableList<Cryptos>
)
