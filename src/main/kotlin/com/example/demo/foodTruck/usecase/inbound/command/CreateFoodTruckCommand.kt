package com.example.demo.foodTruck.usecase.inbound.command

data class CreateFoodTruckCommand (
    val name: String,
    val foodType: String
)