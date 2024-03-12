package com.example.demo.review.usecase.inbound.service

import com.example.demo.review.domain.Review
import com.example.demo.review.usecase.inbound.command.CreateReviewCommand
import com.example.demo.review.usecase.outbound.SaveReviewPort
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CreateReviewService(
    private val saveReviewPort: SaveReviewPort
) {
    fun createReview(command: CreateReviewCommand) {
        val review = Review(
            starRating = command.rating,
            comment = command.comment,
            reviewDate = LocalDateTime.now(),
            userId = command.userId,
            foodTruckId = command.foodTruckId
        )

        saveReviewPort.saveReview(review)
    }
}