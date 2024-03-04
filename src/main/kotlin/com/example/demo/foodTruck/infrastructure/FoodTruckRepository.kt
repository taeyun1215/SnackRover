package com.example.demo.foodTruck.infrastructure

import com.example.demo.foodTruck.domain.FoodTruckWithAvgStarRatingAndReviewCount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FoodTruckRepository :JpaRepository<FoodTruckJpaEntity, Long> {

    @Query("SELECT new com.example.demo.foodTruck.domain.FoodTruckWithAvgStarRatingAndReviewCount(" +
            "f.id, f.name, f.foodType.name, f.operatingStatus, AVG(r.avgStarRating), COUNT(r.id)) " +
            "FROM FoodTruckJpaEntity f " +
            "LEFT JOIN ReviewJpaEntity r ON f.id = r.foodTruckId " +
            "WHERE f.id = :foodTruckId " +
            "GROUP BY f.id"
    ) fun findFoodTruckWithAvgStarRatingAndReviewCountById(
        @Param("foodTruckId") foodTruckId: Long
    ): Optional<FoodTruckWithAvgStarRatingAndReviewCount>

    @Query("SELECT new com.example.demo.foodTruck.domain.FoodTruckWithAvgStarRatingAndReviewCount(" +
            "f.id, f.name, f.foodType, f.operatingStatus, f.avgStarRating, COUNT(r.id)) " +
            "FROM FoodTruckJpaEntity f " +
            "LEFT JOIN ReviewJpaEntity r ON f.id = r.foodTruckId " +
            "WHERE f.latitude BETWEEN :southwestLat AND :northeastLat " +
            "AND f.longitude BETWEEN :southwestLng AND :northeastLng " +
            "GROUP BY f.id"
    ) fun mapSearchFoodTrucksWithinMapBounds(
        @Param("northeastLat") northeastLat: Double,
        @Param("northeastLng") northeastLng: Double,
        @Param("southwestLat") southwestLat: Double,
        @Param("southwestLng") southwestLng: Double
    ): List<FoodTruckWithAvgStarRatingAndReviewCount>
}