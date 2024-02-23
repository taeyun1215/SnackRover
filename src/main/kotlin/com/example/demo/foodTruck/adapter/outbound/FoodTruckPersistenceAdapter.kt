package com.example.demo.foodTruck.adapter.outbound

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.demo.foodTruck.infrastructure.FoodTruckRepository
import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery
import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort
import com.example.demo.foodTruck.usecase.outbound.SaveFoodTruckPort

class FoodTruckPersistenceAdapter(
    private val foodTruckRepository: FoodTruckRepository,
    private val foodTruckMapper: FoodTruckMapper
) : SaveFoodTruckPort, LoadFoodTruckPort {

    override fun saveFoodTruck(foodTruck: FoodTruck) {
        foodTruckRepository.save(foodTruckMapper.mapToJpaEntity(foodTruck))
    }

    override fun loadFoodTruckById(foodTruckId: Long): FoodTruck? {
        return foodTruckRepository.findById(foodTruckId).orElse(null)?.let { foodTruckJpaEntity ->
            foodTruckMapper.mapToDomainEntity(foodTruckJpaEntity)
        }
    }

    override fun mapSearchFoodTrucksWithinMapBounds(mapSearchFoodTruckQuery: MapSearchFoodTruckQuery): List<FoodTruck> {
        val foodTrucks = foodTruckRepository.mapSearchFoodTrucksWithinMapBounds(
            mapSearchFoodTruckQuery.mapBoundsNortheastLatitude,
            mapSearchFoodTruckQuery.mapBoundsNortheastLongitude,
            mapSearchFoodTruckQuery.mapBoundsSouthwestLatitude,
            mapSearchFoodTruckQuery.mapBoundsSouthwestLongitude,
        ).map { foodTruckJpaEntity ->
            foodTruckMapper.mapToDomainEntity(foodTruckJpaEntity)
        }
        return foodTrucks
    }
}