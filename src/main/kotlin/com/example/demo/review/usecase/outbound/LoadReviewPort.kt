package com.example.demo.review.usecase.outbound

import com.example.demo.review.domain.ReviewWithUsername
import com.example.demo.review.usecase.inbound.query.FindReviewQuery

interface LoadReviewPort {
    fun loadReviewsByFoodTruckId(query: FindReviewQuery): List<ReviewWithUsername>
}