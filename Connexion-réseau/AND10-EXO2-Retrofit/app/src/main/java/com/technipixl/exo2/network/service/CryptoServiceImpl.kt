package com.technipixl.exo2.network.service

import com.technipixl.exo2.network.models.CryptoResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CryptoServiceImpl {
        fun getRetrofit(): Retrofit {
            val okBuilder = OkHttpClient().newBuilder().apply {
                connectTimeout(60, TimeUnit.SECONDS)
                callTimeout(60, TimeUnit.SECONDS)
                readTimeout(60, TimeUnit.SECONDS)
                writeTimeout(60, TimeUnit.SECONDS)
            }

            return Retrofit.Builder()
                .baseUrl("https://api.coincap.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build())
                .build()
        }
        suspend fun getCryptoList(): Response<CryptoResponse> =
            getRetrofit().create(CryptoService::class.java).getCryptoList() //methode créer dans la data class CryptoResponse
    }
