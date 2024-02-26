package com.example.demo.review.adapter.inbound.web

import com.example.demo.review.adapter.inbound.payload.FindReviewsResponse
import com.example.demo.review.usecase.inbound.query.FindReviewQuery
import com.example.demo.review.usecase.inbound.service.FindReviewService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/food-trucks")
class FindReviewController(private val findReviewService: FindReviewService) {

    @GetMapping("/{foodTruckId}/reviews")
    fun findReviewsByFoodTruckId(@PathVariable foodTruckId: Long): ResponseEntity<FindReviewsResponse> {
        val findReviewQuery = FindReviewQuery(
            foodTruckId = foodTruckId
        )

        val reviews = findReviewService.findReviewsByFoodTruckId(findReviewQuery)
        return ResponseEntity.ok(reviews)
    }
}