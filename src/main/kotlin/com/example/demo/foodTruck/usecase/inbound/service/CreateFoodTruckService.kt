package com.example.demo.foodTruck.usecase.inbound.service

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.demo.foodTruck.domain.FoodType.Companion.validationFoodType
import com.example.demo.foodTruck.usecase.inbound.command.CreateFoodTruckCommand
import com.example.demo.foodTruck.usecase.outbound.SaveFoodTruckPort
import com.example.demo.user.domain.User
import com.example.demo.user.usecase.outbound.LoadUserPort
import org.springframework.stereotype.Service

@Service
class CreateFoodTruckService(
    private val saveFoodTruckPort: SaveFoodTruckPort,
    private val loadUserPort: LoadUserPort
) {
    fun createFoodTruck(command: CreateFoodTruckCommand) {
        val user = loadUserPort.findByUserId(command.userId)
            ?: throw IllegalArgumentException(
                "User not found with ID: ${command.userId}"
            )

        val foodTruck = FoodTruck(
            name = command.name,
            foodType = validationFoodType(command.foodType),
            operatingStatus = false,
            starRating = 0f,
            reviewCount = 0,
            user = user
        )

        saveFoodTruckPort.saveFoodTruck(foodTruck)
    }
}