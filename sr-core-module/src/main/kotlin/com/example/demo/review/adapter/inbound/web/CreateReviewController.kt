package com.example.demo.review.adapter.inbound.web

import com.example.demo.review.adapter.inbound.payload.CommonReviewResponse
import com.example.demo.review.adapter.inbound.payload.CreateReviewRequest
import com.example.demo.review.usecase.inbound.command.CreateReviewCommand
import com.example.demo.review.usecase.inbound.service.CreateReviewService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reviews")
class CreateReviewController(
    private val createReviewService: CreateReviewService
) {
    @PostMapping
    fun createReview(@RequestBody request: CreateReviewRequest): ResponseEntity<CommonReviewResponse> {
        val createReviewCommand = CreateReviewCommand(
            rating = request.rating,
            comment = request.comment,
            userId = request.userId,
            foodTruckId = request.foodTruckId
        )

        createReviewService.createReview(createReviewCommand)

        return ResponseEntity.ok(CommonReviewResponse("리뷰가 등록되었습니다."))
    }
}