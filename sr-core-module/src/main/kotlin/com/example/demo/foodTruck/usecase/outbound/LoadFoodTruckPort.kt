package com.example.demo.foodTruck.usecase.outbound

import com.example.demo.foodTruck.domain.FoodTruckWithAvgStarRatingAndReviewCount
import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery

interface LoadFoodTruckPort {
    fun loadFoodTruckById(foodTruckId: Long): FoodTruckWithAvgStarRatingAndReviewCount
    fun mapSearchFoodTrucksWithinMapBounds(mapSearchFoodTruckQuery: MapSearchFoodTruckQuery): List<FoodTruckWithAvgStarRatingAndReviewCount>
}