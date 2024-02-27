package com.example.demo.review.usecase.inbound.service

import com.example.demo.review.domain.ReviewWithUsername
import com.example.demo.review.usecase.inbound.query.FindReviewQuery
import com.example.demo.review.usecase.outbound.LoadReviewPort
import org.springframework.stereotype.Service

@Service
class FindReviewService(
    private val loadReviewPort: LoadReviewPort
) {
    fun findReviewsByFoodTruckId(query: FindReviewQuery): List<ReviewWithUsername> {
        return loadReviewPort.loadReviewsByFoodTruckId(query)
    }
}