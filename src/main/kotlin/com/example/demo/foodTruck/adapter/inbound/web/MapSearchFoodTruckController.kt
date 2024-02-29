package com.example.demo.foodTruck.adapter.inbound.web

import com.example.demo.foodTruck.adapter.inbound.payload.DetailFoodTruckResponse
import com.example.demo.foodTruck.adapter.inbound.payload.MapSearchFoodTruckRequest
import com.example.demo.foodTruck.adapter.inbound.payload.MapSearchFoodTrucksResponse
import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery
import com.example.demo.foodTruck.usecase.inbound.service.MapSearchFoodTruckService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/food-trucks")
class MapSearchFoodTruckController(private val mapSearchFoodTruckService: MapSearchFoodTruckService) {

    @PostMapping("/search")
    fun searchFoodTrucks(@RequestBody request: MapSearchFoodTruckRequest): ResponseEntity<MapSearchFoodTrucksResponse> {
        val mapSearchFoodTruckQuery = MapSearchFoodTruckQuery(
            currentUserLatitude = request.currentUserLongitude,
            currentUserLongitude = request.currentUserLongitude,
            mapBoundsNortheastLatitude = request.mapBoundsNortheastLatitude,
            mapBoundsNortheastLongitude = request.mapBoundsNortheastLongitude,
            mapBoundsSouthwestLatitude = request.mapBoundsSouthwestLatitude,
            mapBoundsSouthwestLongitude = request.mapBoundsSouthwestLongitude,
        )

        val foodTrucks = mapSearchFoodTruckService.mapSearchFoodTrucksWithinMapBounds(mapSearchFoodTruckQuery).map { foodTruck ->
            DetailFoodTruckResponse(
                foodTruckId = foodTruck.foodTruckId!!, // foodTruck.id가 null이 아니라고 확신할 때 사용
                name = foodTruck.name,
                foodType = foodTruck.foodType,
                operatingStatus = foodTruck.operatingStatus,
                starRating = foodTruck.starRating,
                reviewCount = foodTruck.reviewCount
            )
        }
        val response = MapSearchFoodTrucksResponse(foodTrucks = foodTrucks)
        return ResponseEntity.ok(response)
    }
}