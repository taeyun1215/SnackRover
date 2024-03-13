package com.example.demo.foodTruck.adapter.inbound.web

import com.example.demo.foodTruck.adapter.inbound.payload.MapSearchFoodTruckRequest
import com.example.demo.foodTruck.adapter.inbound.payload.MapSearchFoodTrucksResponse
import com.example.demo.foodTruck.usecase.inbound.query.MapSearchFoodTruckQuery
import com.example.demo.foodTruck.usecase.inbound.service.MapSearchFoodTruckService
import com.example.foodTruck.FoodType
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

        val mapSearchFoodTrucksResponse = mapSearchFoodTruckService.mapSearchFoodTrucksWithinMapBounds(mapSearchFoodTruckQuery).map { foodTrucksWithStarRatingAndReviewCount ->
            MapSearchFoodTrucksResponse.MapSearchFoodTruckResponse(
                foodTruckId = foodTrucksWithStarRatingAndReviewCount.foodTruckId,
                name = foodTrucksWithStarRatingAndReviewCount.name,
                foodType = FoodType.valueOf(foodTrucksWithStarRatingAndReviewCount.foodType),
                operatingStatus = foodTrucksWithStarRatingAndReviewCount.operatingStatus,
                avgStarRating = foodTrucksWithStarRatingAndReviewCount.avgStarRating,
                reviewCount = foodTrucksWithStarRatingAndReviewCount.reviewCount
            )
        }

        return ResponseEntity.ok(MapSearchFoodTrucksResponse(mapSearchFoodTrucksResponse = mapSearchFoodTrucksResponse))
    }
}