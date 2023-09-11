package com.anahitavakoli.apps.foodmood.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://flutterapps.ir/apps/snappfood/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}