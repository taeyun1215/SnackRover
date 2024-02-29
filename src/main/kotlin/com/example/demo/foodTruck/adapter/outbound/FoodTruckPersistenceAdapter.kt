package com.example.demo.foodTruck.adapter.outbound

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.demo.foodTruck.infrastructure.FoodTruckRepository
import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery
import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort
import com.example.demo.foodTruck.usecase.outbound.SaveFoodTruckPort
import com.example.demo.foodTruck.usecase.outbound.UpdateFoodTruckPort
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component

@Component
class FoodTruckPersistenceAdapter(
    private val foodTruckRepository: FoodTruckRepository,
    private val foodTruckMapper: FoodTruckMapper
) : SaveFoodTruckPort, LoadFoodTruckPort, UpdateFoodTruckPort {

    override fun saveFoodTruck(foodTruck: FoodTruck) {
        foodTruckRepository.save(foodTruckMapper.mapToJpaEntity(foodTruck))
    }

    override fun loadFoodTruckById(foodTruckId: Long): FoodTruck {
        return foodTruckRepository.findById(foodTruckId).map { foodTruckJpaEntity ->
            foodTruckMapper.mapToDomainEntity(foodTruckJpaEntity)
        }.orElseThrow {
            throw EntityNotFoundException("FoodTruck with foodTruckId $foodTruckId not found")
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

    override fun updateFoodTruck(foodTruck: FoodTruck) {
        val foodTruckJpaEntity = foodTruckMapper.mapToJpaEntityForUpdate(foodTruck)
        foodTruckRepository.save(foodTruckJpaEntity)
    }
}