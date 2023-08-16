package com.technipixl.exo2.network

import com.technipixl.exo2.models.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CryptoService {
    @Headers("Content-type: application/json")
    @GET("assets")
    suspend fun data(): Response<CryptoResponse>
}