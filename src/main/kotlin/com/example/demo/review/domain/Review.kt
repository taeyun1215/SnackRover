package com.example.demo.review.domain

import java.time.LocalDateTime

data class Review (
    val reviewId: Long? = null,
    var rating: Int,
    var comment: String,
    var reviewDate: LocalDateTime,
    var username: String,
    var foodTruckId: Long
)