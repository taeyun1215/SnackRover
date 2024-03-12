package com.example.demo.foodTruck.usecase.inbound.service

import com.example.demo.foodTruck.domain.FoodTruckWithAvgStarRatingAndReviewCount
import com.example.demo.foodTruck.usecase.inbound.query.FindFoodTruckQuery
import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort
import org.springframework.stereotype.Service

@Service
class FindFoodTruckService(
    private val loadFoodTruckPort: LoadFoodTruckPort
) {
    fun findFoodTruckById(query: FindFoodTruckQuery): FoodTruckWithAvgStarRatingAndReviewCount {
        return loadFoodTruckPort.loadFoodTruckById(query.foodTruckId)
    }
}