package com.example.demo.foodTruck.usecase.outbound

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery

interface LoadFoodTruckPort {
    fun loadFoodTruckById(foodTruckId: Long): FoodTruck?
    fun mapSearchFoodTrucksWithinMapBounds(mapSearchFoodTruckQuery: MapSearchFoodTruckQuery): List<FoodTruck>
}