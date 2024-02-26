package com.example.demo.review.usecase.inbound.command

data class CreateReviewCommand (
    var rating: Int,
    var comment: String,
    var userId: Long,
    var foodTruckId: Long
)
