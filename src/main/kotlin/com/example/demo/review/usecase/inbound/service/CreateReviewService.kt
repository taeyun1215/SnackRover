package com.example.demo.review.usecase.inbound.service

import com.example.demo.review.domain.Review
import com.example.demo.review.usecase.inbound.command.CreateReviewCommand
import com.example.demo.review.usecase.outbound.SaveReviewPort
import java.time.LocalDateTime

class CreateReviewService(
    private val saveReviewPort: SaveReviewPort
) {
    fun createReview(command: CreateReviewCommand) {
        val review = Review(
            rating = command.rating,
            comment = command.comment,
            reviewDate = LocalDateTime.now(),
            userId = command.userId,
            foodTruckId = command.foodTruckId
        )

        saveReviewPort.saveReview(review)
    }
}