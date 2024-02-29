package com.example.demo.foodTruck.adapter.inbound.payload

import com.example.demo.foodTruck.domain.FoodType

data class MapSearchFoodTrucksResponse(
    val foodTrucks: List<MapSearchFoodTruckResponse>
) {
    data class MapSearchFoodTruckResponse(
        val foodTruckId: Long,
        val name: String,
        val foodType: FoodType,
        var operatingStatus: Boolean,
        var starRating: Float,
        var reviewCount: Int
    )
}