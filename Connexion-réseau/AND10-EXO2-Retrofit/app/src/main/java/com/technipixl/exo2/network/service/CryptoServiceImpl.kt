package com.technipixl.exo2.network.service

import com.technipixl.exo2.network.model.CryptoResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class CryptoServiceImpl {

    private fun retrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            callTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
        }.build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.coincap.io/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    suspend fun getCryptoList(): Response<CryptoResponse> {
        return  retrofit().create(CryptoService::class.java).getCryptoList()
    }
}