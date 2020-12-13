package com.example.myapplication.api

import com.example.myapplication.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

     val retrofit : ProductApi by lazy {
        val retrofit2 = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
         retrofit2.create(ProductApi::class.java)
    }


}