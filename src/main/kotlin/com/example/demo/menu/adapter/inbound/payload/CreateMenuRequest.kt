package com.example.demo.menu.adapter.inbound.payload

data class CreateMenuRequest(
    val name: String,
    val description: String,
    val price: Float,
    val foodTruckId: Long
)