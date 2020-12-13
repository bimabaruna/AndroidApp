package com.example.myapplication.Model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ProductModel (

    val code : Int,

    val id : String,

    @SerializedName ("name")
    var productName : String,

    @SerializedName ("price")
    val price : Long,


    val quantity : Int,


    val createdAt : Date,


    val updatedAt : Date?

)
