package com.example.demo.foodTruck.adapter.inbound.web

import com.example.demo.foodTruck.adapter.inbound.payload.DetailFoodTruckResponse
import com.example.demo.foodTruck.usecase.inbound.query.FindFoodTruckQuery
import com.example.demo.foodTruck.usecase.inbound.service.FindFoodTruckService
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

        val foodTruckDetail = findFoodTruckService.findFoodTruckById(findFoodTruckQuery)
        return ResponseEntity.ok(foodTruckDetail.foodTruckId?.let {
            DetailFoodTruckResponse(
                foodTruckId = it,
                name = foodTruckDetail.name,
                foodType = foodTruckDetail.foodType,
                operatingStatus = foodTruckDetail.operatingStatus,
                starRating = foodTruckDetail.starRating,
                reviewCount = foodTruckDetail.reviewCount
            )
        })
    }
}
