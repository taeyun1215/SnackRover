package com.example.demo.foodTruck.adapter.inbound.web

import com.example.demo.foodTruck.adapter.inbound.payload.DetailFoodTruckResponse
import com.example.demo.foodTruck.usecase.inbound.query.FindFoodTruckQuery
import com.example.demo.foodTruck.usecase.inbound.service.FindFoodTruckService
import com.example.foodTruck.FoodType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/food-trucks")
class FindFoodTruckController(private val findFoodTruckService: FindFoodTruckService) {

    @GetMapping("/{foodTruckId}")
    fun findFoodTruckById(@PathVariable foodTruckId: Long): ResponseEntity<DetailFoodTruckResponse> {
        val findFoodTruckQuery = FindFoodTruckQuery(
            foodTruckId = foodTruckId
        )

        findFoodTruckService.findFoodTruckById(findFoodTruckQuery).let { foodTruckWithAvgStarRatingAndReviewCountDto ->
            return ResponseEntity.ok(
                DetailFoodTruckResponse(
                    foodTruckId = foodTruckWithAvgStarRatingAndReviewCountDto.foodTruckId,
                    name = foodTruckWithAvgStarRatingAndReviewCountDto.name,
                    foodType = FoodType.valueOf(foodTruckWithAvgStarRatingAndReviewCountDto.foodType),
                    operatingStatus = foodTruckWithAvgStarRatingAndReviewCountDto.operatingStatus,
                    avgStarRating = foodTruckWithAvgStarRatingAndReviewCountDto.avgStarRating,
                    reviewCount = foodTruckWithAvgStarRatingAndReviewCountDto.reviewCount
                )
            )
        }
    }
}
