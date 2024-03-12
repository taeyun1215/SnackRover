package com.example.demo.menu.domain

data class Menu(
    val menuId: Long? = null,
    val name: String,
    val description: String,
    val price: Float,
    val foodTruckId: Long
)