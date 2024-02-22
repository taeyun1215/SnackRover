package com.example.demo.foodTruck.adapter.inbound.payload

data class CreateFoodTruckRequest(
    val name: String,
    val foodType: String,
    val userId: Long
) {
    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(foodType.isNotBlank()) { "FoodType cannot be blank" }
    }
}