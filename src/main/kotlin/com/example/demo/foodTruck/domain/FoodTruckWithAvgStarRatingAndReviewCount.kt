package com.example.demo.foodTruck.domain

data class FoodTruckWithAvgStarRatingAndReviewCount(
    val foodTruckId: Long,
    val name: String,
    val foodType: String,
    val operatingStatus: Boolean,
    val avgStarRating: Double,
    val reviewCount: Long
)