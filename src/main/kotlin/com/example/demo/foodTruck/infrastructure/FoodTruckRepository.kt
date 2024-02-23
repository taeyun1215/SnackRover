package com.example.demo.foodTruck.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface FoodTruckRepository :JpaRepository<FoodTruckJpaEntity, Long> {
    // 지도 범위 내의 푸드트럭을 찾는 쿼리 메서드 예시
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