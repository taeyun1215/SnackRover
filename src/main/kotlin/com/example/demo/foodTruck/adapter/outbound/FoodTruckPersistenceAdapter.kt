package com.example.demo.foodTruck.adapter.outbound

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.demo.foodTruck.infrastructure.FoodTruckRepository
import com.example.demo.foodTruck.usecase.outbound.SaveFoodTruckPort

class FoodTruckPersistenceAdapter(
    private val foodTruckRepository: FoodTruckRepository,
    private val foodTruckMapper: FoodTruckMapper
) : SaveFoodTruckPort {

    override fun saveFoodTruck(foodTruck: FoodTruck) {
        foodTruckRepository.save(foodTruckMapper.mapToJpaEntity(foodTruck))
    }
}