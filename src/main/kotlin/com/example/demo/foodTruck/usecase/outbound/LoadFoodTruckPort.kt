package com.example.demo.foodTruck.usecase.outbound

import com.example.demo.foodTruck.domain.FoodTruck

interface LoadFoodTruckPort {
    fun loadFoodTruckById(foodTruckId: Long): FoodTruck?
}