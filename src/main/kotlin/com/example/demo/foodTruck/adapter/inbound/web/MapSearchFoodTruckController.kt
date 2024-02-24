package com.example.demo.foodTruck.adapter.inbound.web

import com.example.demo.foodTruck.adapter.inbound.payload.DetailFoodTruckResponse
import com.example.demo.foodTruck.adapter.inbound.payload.MapSearchFoodTruckRequest
import com.example.demo.foodTruck.adapter.inbound.payload.MapSearchFoodTruckResponse
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
    fun searchFoodTrucks(@RequestBody request: MapSearchFoodTruckRequest): ResponseEntity<MapSearchFoodTruckResponse> {
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
                foodTruckId = foodTruck.id ?: 0L, // 오타 수정: id null 체크 필요한지 확인
                name = foodTruck.name,
                foodType = foodTruck.foodType,
                operatingStatus = foodTruck.operatingStatus,
                starRating = foodTruck.starRating,
                reviewCount = foodTruck.reviewCount
            )
        }
        val response = MapSearchFoodTruckResponse(foodTrucks = foodTrucks)
        return ResponseEntity.ok(response)
    }
}