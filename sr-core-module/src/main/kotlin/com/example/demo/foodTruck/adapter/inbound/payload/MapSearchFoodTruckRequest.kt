package com.example.demo.foodTruck.adapter.inbound.payload

data class MapSearchFoodTruckRequest(
    val currentUserLatitude: Double,
    val currentUserLongitude: Double,
    val mapBoundsNortheastLatitude: Double,
    val mapBoundsNortheastLongitude: Double,
    val mapBoundsSouthwestLatitude: Double,
    val mapBoundsSouthwestLongitude: Double
)