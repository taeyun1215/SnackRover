package com.example.demo.foodTruck.usecase.outbound

import com.example.demo.foodTruck.domain.FoodTruck

interface UpdateFoodTruckPort {
    fun updateFoodTruck(foodTruck: FoodTruck)
}