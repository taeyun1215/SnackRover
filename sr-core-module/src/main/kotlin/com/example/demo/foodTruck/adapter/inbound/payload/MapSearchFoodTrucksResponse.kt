package com.example.demo.foodTruck.adapter.inbound.payload

import com.example.foodTruck.FoodType

data class MapSearchFoodTrucksResponse(
    val mapSearchFoodTrucksResponse: List<MapSearchFoodTruckResponse>
) {
    data class MapSearchFoodTruckResponse(
        val foodTruckId: Long,
        val name: String,
        val foodType: FoodType,
        var operatingStatus: Boolean,
        var avgStarRating: Double,
        var reviewCount: Long
    )
}