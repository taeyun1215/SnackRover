package com.example.demo.foodTruck.adapter.outbound

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.foodTruck.FoodTruckRepository
import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery
import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort
import com.example.demo.foodTruck.usecase.outbound.SaveFoodTruckPort
import com.example.demo.foodTruck.usecase.outbound.UpdateFoodTruckPort
import com.example.foodTruck.FoodTruckWithAvgStarRatingAndReviewCount
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

    override fun loadFoodTruckById(foodTruckId: Long): FoodTruckWithAvgStarRatingAndReviewCount {
        return foodTruckRepository.findFoodTruckWithAvgStarRatingAndReviewCountById(foodTruckId)
            .orElseThrow {
                EntityNotFoundException("FoodTruck not found with id: $foodTruckId")
            }
    }

    override fun mapSearchFoodTrucksWithinMapBounds(mapSearchFoodTruckQuery: MapSearchFoodTruckQuery): List<FoodTruckWithAvgStarRatingAndReviewCount> {
        return foodTruckRepository.mapSearchFoodTrucksWithinMapBounds(
            mapSearchFoodTruckQuery.mapBoundsNortheastLatitude,
            mapSearchFoodTruckQuery.mapBoundsNortheastLongitude,
            mapSearchFoodTruckQuery.mapBoundsSouthwestLatitude,
            mapSearchFoodTruckQuery.mapBoundsSouthwestLongitude,
        )
    }

    override fun updateFoodTruck(foodTruck: FoodTruck) {
        val foodTruckJpaEntity = foodTruckMapper.mapToJpaEntityForUpdate(foodTruck)
        foodTruckRepository.save(foodTruckJpaEntity)
    }
}