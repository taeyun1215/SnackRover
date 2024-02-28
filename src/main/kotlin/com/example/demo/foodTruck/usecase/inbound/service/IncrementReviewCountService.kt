package com.example.demo.foodTruck.usecase.inbound.service

import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort
import com.example.demo.foodTruck.usecase.outbound.UpdateFoodTruckPort
import org.springframework.stereotype.Service

@Service
class IncrementReviewCountService(
    private val loadFoodTruckPort: LoadFoodTruckPort,
    private val updateFoodTruckPort: UpdateFoodTruckPort
) {
    fun incrementReviewCount(foodTruckId: Long) {
        val foodTruck = loadFoodTruckPort.loadFoodTruckById(foodTruckId)
        foodTruck.reviewCountUp()

        updateFoodTruckPort.updateFoodTruck(foodTruck)
    }
}