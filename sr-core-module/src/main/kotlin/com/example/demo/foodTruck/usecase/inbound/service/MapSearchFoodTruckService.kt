package com.example.demo.foodTruck.usecase.inbound.service

import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery
import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort
import com.example.foodTruck.FoodTruckWithAvgStarRatingAndReviewCount
import org.springframework.stereotype.Service

@Service
class MapSearchFoodTruckService(
    private val loadFoodTruckPort: LoadFoodTruckPort
) {
    fun mapSearchFoodTrucksWithinMapBounds(query: MapSearchFoodTruckQuery): List<FoodTruckWithAvgStarRatingAndReviewCount> {
        return loadFoodTruckPort.mapSearchFoodTrucksWithinMapBounds(query)
    }
}