package com.example.demo.review.domain

import java.time.LocalDateTime

data class ReviewWithUsername(
    val reviewId: Long,
    val rating: Int,
    val comment: String,
    val reviewDate: LocalDateTime,
    val username: String,
)