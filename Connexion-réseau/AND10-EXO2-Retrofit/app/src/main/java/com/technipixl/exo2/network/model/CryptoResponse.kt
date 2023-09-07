package com.technipixl.exo2.network.model

import com.google.gson.annotations.SerializedName

//3. Création des modèles

//Correspond à la structure globale de la réponse JSON de l'API. Elle contient une liste de cryptomonnaies.
data class CryptoResponse(
    val data: List<Crypto>
)

//Correspond à la structure d'une cryptomonnaie individuelle dans la réponse JSON.
data class Crypto(
    val id: String,
    val name: String,
    val symbol: String,
    val changePercent24Hr: String
) {
    fun toPercent(): Double {
        return changePercent24Hr.toDouble()
    }
}
