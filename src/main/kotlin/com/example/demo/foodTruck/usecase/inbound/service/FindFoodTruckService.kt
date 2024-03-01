package com.example.demo.foodTruck.usecase.inbound.service

import com.example.demo.foodTruck.adapter.outbound.dto.FoodTruckWithAvgStarRatingAndReviewCountDto
import com.example.demo.foodTruck.domain.FoodTruck
import com.example.demo.foodTruck.usecase.inbound.query.FindFoodTruckQuery
import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort
import org.springframework.stereotype.Service

@Service
class FindFoodTruckService(
    private val loadFoodTruckPort: LoadFoodTruckPort
) {
    fun findFoodTruckById(query: FindFoodTruckQuery): FoodTruckWithAvgStarRatingAndReviewCountDto {
        return loadFoodTruckPort.loadFoodTruckById(query.foodTruckId)
    }
}