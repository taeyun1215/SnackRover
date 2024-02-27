package com.example.demo.review.adapter.inbound.payload

import java.time.LocalDateTime

data class FindReviewsResponse(
    val reviews: List<FindReviewResponse>
) {
    data class FindReviewResponse(
        val reviewId: Long,
        val rating: Int,
        val comment: String,
        val reviewDate: LocalDateTime,
        val username: String,
    )
}