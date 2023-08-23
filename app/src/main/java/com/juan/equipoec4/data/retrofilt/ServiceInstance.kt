package com.juan.equipoec4.data.retrofilt

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.sportmonks.com/v3/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getEquipoService(): Service = retrofit.create(Service::class.java)
}