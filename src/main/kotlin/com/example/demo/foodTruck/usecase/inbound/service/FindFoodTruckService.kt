package com.example.demo.foodTruck.usecase.inbound.service

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.demo.foodTruck.usecase.inbound.query.FindFoodTruckQuery
import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort
import org.springframework.stereotype.Service

@Service
class FindFoodTruckService(
    private val loadFoodTruckPort: LoadFoodTruckPort
) {
    fun findFoodTruckById(findFoodTruckQuery: FindFoodTruckQuery): FoodTruck {
        return loadFoodTruckPort.loadFoodTruckById(findFoodTruckQuery.foodTruckId)
            ?: throw IllegalArgumentException(
                "User not found with ID: ${findFoodTruckQuery.foodTruckId}"
            );
    }
}