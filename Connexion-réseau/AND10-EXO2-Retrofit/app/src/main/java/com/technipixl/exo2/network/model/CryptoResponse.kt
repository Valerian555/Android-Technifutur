package com.technipixl.exo2.network.model

import com.google.gson.annotations.SerializedName

//3. Création des modèles

//Correspond à la structure globale de la réponse JSON de l'API. Elle contient une liste de cryptomonnaies.
data class CryptoResponse(
    @SerializedName("data")
    var cryptoList: MutableList<Crypto>
)

//Correspond à la structure d'une cryptomonnaie individuelle dans la réponse JSON.
data class Crypto(
    var id: String,
    var symbol: String,
    var name: String,
    var changePercent24Hr: String
) {
    fun toPercent(): Double {
        return changePercent24Hr.toDouble()
    }
}
