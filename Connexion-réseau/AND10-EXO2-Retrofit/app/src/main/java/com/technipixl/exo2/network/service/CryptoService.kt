package com.technipixl.exo2.network.service

import com.technipixl.exo2.network.model.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CryptoService {

    @GET("assets")
    suspend fun getCryptoList(): Response<CryptoResponse>
}