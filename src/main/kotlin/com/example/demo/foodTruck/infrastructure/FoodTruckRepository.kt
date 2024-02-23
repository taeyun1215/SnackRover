package com.example.demo.foodTruck.infrastructure

import com.example.demo.foodTruck.domain.FoodTruck
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodTruckRepository :JpaRepository<FoodTruckJpaEntity, Long> {
}