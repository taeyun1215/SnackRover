package com.example.demo.foodTruck.usecase.inbound.query

data class MapSearchFoodTruckQuery (
    val currentUserLatitude: Double,
    val currentUserLongitude: Double,
    val mapBoundsNortheastLatitude: Double,
    val mapBoundsNortheastLongitude: Double,
    val mapBoundsSouthwestLatitude: Double,
    val mapBoundsSouthwestLongitude: Double
)
