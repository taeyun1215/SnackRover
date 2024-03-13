package com.example.review

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<ReviewJpaEntity, Long> {
    fun findByFoodTruckId(foodTruckId: Long): List<ReviewJpaEntity>?
}