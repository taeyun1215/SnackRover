package com.example.demo.menu.usecase.inbound.command

data class CreateMenuCommand(
    val name: String,
    val description: String,
    val price: Float,
    val foodTruckId: Long
)