package com.example.demo.foodTruck.usecase.inbound.service

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery
import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort

class MapSearchFoodTruckService(
    private val loadFoodTruckPort: LoadFoodTruckPort
) {
    fun mapSearchFoodTrucksWithinMapBounds(query: MapSearchFoodTruckQuery): List<FoodTruck> {
        return loadFoodTruckPort.mapSearchFoodTrucksWithinMapBounds(query)
    }
}