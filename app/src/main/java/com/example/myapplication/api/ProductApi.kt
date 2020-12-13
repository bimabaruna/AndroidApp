package com.example.myapplication.api

import com.example.myapplication.Model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {
    @GET("/api/products")
     fun getProduct(
        @Query("size")size: Int,
        @Query("page")page: Int
    ): Call<ProductResponse>
}