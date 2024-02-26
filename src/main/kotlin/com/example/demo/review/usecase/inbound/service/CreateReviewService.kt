package com.example.demo.review.usecase.inbound.service

import com.example.demo.review.domain.Review
import com.example.demo.review.usecase.inbound.command.CreateReviewCommand
import com.example.demo.review.usecase.outbound.SaveReviewPort

class CreateReviewService(
    private val saveReviewPort: SaveReviewPort
) {
    fun createReview(createReviewCommand: CreateReviewCommand) {

    }
}