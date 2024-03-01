package com.example.demo.foodTruck.usecase.outbound

import com.example.demo.foodTruck.adapter.outbound.dto.FoodTruckWithAvgStarRatingAndReviewCountDto
import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery

interface LoadFoodTruckPort {
    fun loadFoodTruckById(foodTruckId: Long): FoodTruckWithAvgStarRatingAndReviewCountDto
    fun mapSearchFoodTrucksWithinMapBounds(mapSearchFoodTruckQuery: MapSearchFoodTruckQuery): List<FoodTruckWithAvgStarRatingAndReviewCountDto>
}