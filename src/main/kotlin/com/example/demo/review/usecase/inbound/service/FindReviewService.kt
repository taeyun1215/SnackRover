package com.example.demo.review.usecase.inbound.service

import com.example.demo.review.domain.ReviewWithUsername
import com.example.demo.review.usecase.inbound.query.FindReviewQuery
import com.example.demo.review.usecase.outbound.LoadReviewPort
import com.example.demo.user.usecase.outbound.LoadUserPort
import org.springframework.stereotype.Service

@Service
class FindReviewService(
    private val loadReviewPort: LoadReviewPort,
    private val loadUserPort: LoadUserPort
) {
    fun findReviewsByFoodTruckId(query: FindReviewQuery): List<ReviewWithUsername> {
        val reviews = loadReviewPort.loadReviewsByFoodTruckId(query)

        return reviews.map { review ->
            ReviewWithUsername(
                reviewId = review.reviewId!!,
                rating = review.starRating,
                comment = review.comment,
                reviewDate = review.reviewDate,
                username = loadUserPort.findByUserId(review.userId).username
            )
        }
    }
}