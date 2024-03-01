package com.example.demo.foodTruck.adapter.outbound.dto

data class FoodTruckWithAvgStarRatingAndReviewCountDto(
    val foodTruckId: Long,
    val name: String,
    val foodType: String,
    val operatingStatus: Boolean,
    val avgStarRating: Float,
    val reviewCount: Long
)