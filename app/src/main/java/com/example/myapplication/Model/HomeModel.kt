package com.example.myapplication.Model

import java.util.*

data class Food (var title: String)

object Filter{

    val menu = listOf(
        Food("kebab bakar"),
        Food("kebab Rebus"),
        Food("kebab goreng"),
        Food("kebab daging"),
        Food("kebab ayam"),
        Food("kebab bakar"),
        Food("kebab Rebus"),
        Food("kebab goreng"),
        Food("kebab daging"),
        Food("kebab ayam"),
        Food("kebab bakar"),
        Food("kebab Rebus"),
        Food("kebab goreng"),
        Food("kebab daging"),
        Food("kebab ayam"),
        Food("kebab bakar"),
        Food("kebab Rebus"),
        Food("kebab goreng"),
        Food("kebab daging"),
        Food("kebab ayam"),
        Food("kebab bakar"),
        Food("kebab Rebus"),
        Food("kebab goreng"),
        Food("kebab daging"),
        Food("kebab ayam")


    )


}
data class Tab ( var title: String )

object title {
    val tab = listOf(
        Tab("Home"),
        Tab("Menu"),
        Tab("Profile")
    )

}


data class Product (


    val id : String,


    val name : String,


    val price : Long,


    val quantity : Int,


    val createdAt : Date,


    val updatedAt : Date?

)