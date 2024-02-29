package com.example.demo.foodTruck.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface FoodTruckRepository :JpaRepository<FoodTruckJpaEntity, Long> {

    @Query("FROM FoodTruckJpaEntity FT " +
            "WHERE FT.latitude " +
            "BETWEEN :southwestLat " +
            "AND :northeastLat" +
            "AND FT.longitude " +
            "BETWEEN :southwestLng " +
            "AND :northeastLng"
    ) fun mapSearchFoodTrucksWithinMapBounds(
        @Param("northeastLat") northeastLat: Double,
        @Param("northeastLng") northeastLng: Double,
        @Param("southwestLat") southwestLat: Double,
        @Param("southwestLng") southwestLng: Double
    ): List<FoodTruckJpaEntity>
}