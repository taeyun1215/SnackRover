package com.example.foodTruck

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FoodTruckRepository :JpaRepository<FoodTruckJpaEntity, Long> {

    @Query("SELECT new FoodTruckWithAvgStarRatingAndReviewCount(" +
            "f.id, f.name, f.foodType.toString(), f.operatingStatus, COALESCE(AVG(r.starRating), 0), COUNT(r)) " +
            "FROM FoodTruckJpaEntity f " +
            "LEFT JOIN ReviewJpaEntity r ON f.id = r.foodTruckId " +
            "WHERE f.id = :foodTruckId " +
            "GROUP BY f.id, f.name, f.foodType, f.operatingStatus")
    fun findFoodTruckWithAvgStarRatingAndReviewCountById(
        @Param("foodTruckId") foodTruckId: Long
    ): Optional<FoodTruckWithAvgStarRatingAndReviewCount>

    @Query("SELECT new FoodTruckWithAvgStarRatingAndReviewCount(" +
            "f.id, f.name, f.foodType.toString(), f.operatingStatus, COALESCE(AVG(r.starRating), 0), COUNT(r)) " +
            "FROM FoodTruckJpaEntity f " +
            "LEFT JOIN LocationLog l ON f.id = l.foodTruckId " +
            "LEFT JOIN ReviewJpaEntity r ON f.id = r.foodTruckId " +
            "WHERE l.latitude BETWEEN :southwestLat AND :northeastLat " +
            "AND l.longitude BETWEEN :southwestLng AND :northeastLng " +
            "GROUP BY f.id, f.name, f.foodType, f.operatingStatus")
    fun mapSearchFoodTrucksWithinMapBounds(
        @Param("northeastLat") northeastLat: Double,
        @Param("northeastLng") northeastLng: Double,
        @Param("southwestLat") southwestLat: Double,
        @Param("southwestLng") southwestLng: Double
    ): List<FoodTruckWithAvgStarRatingAndReviewCount>
}