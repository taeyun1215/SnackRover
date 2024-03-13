package com.example.demo.foodTruck.usecase.outbound

import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery
import com.example.foodTruck.FoodTruckWithAvgStarRatingAndReviewCount

interface LoadFoodTruckPort {
    fun loadFoodTruckById(foodTruckId: Long): FoodTruckWithAvgStarRatingAndReviewCount
    fun mapSearchFoodTrucksWithinMapBounds(mapSearchFoodTruckQuery: MapSearchFoodTruckQuery): List<FoodTruckWithAvgStarRatingAndReviewCount>
}