package com.example.demo.foodTruck.usecase.inbound.service

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.demo.foodTruck.domain.FoodType.Companion.validationFoodType
import com.example.demo.foodTruck.usecase.inbound.command.CreateFoodTruckCommand
import com.example.demo.foodTruck.usecase.outbound.SaveFoodTruckPort
import org.springframework.stereotype.Service

@Service
class CreateFoodTruckService(private val saveFoodTruckPort: SaveFoodTruckPort) {

    fun createFoodTruck(createFoodTruckCommand: CreateFoodTruckCommand) {
        val foodTruck = FoodTruck(
            name = createFoodTruckCommand.name,
            foodType = validationFoodType(createFoodTruckCommand.foodType)
        )
    }
}