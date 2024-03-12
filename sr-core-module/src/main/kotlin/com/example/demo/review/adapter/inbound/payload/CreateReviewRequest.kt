package com.example.demo.review.adapter.inbound.payload

data class CreateReviewRequest (
    var rating: Int,
    var comment: String,
    var userId: Long,
    var foodTruckId: Long
)