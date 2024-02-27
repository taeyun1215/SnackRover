package com.example.demo.review.usecase.inbound.service

import com.example.demo.foodTruck.usecase.outbound.LoadFoodTruckPort
import com.example.demo.foodTruck.usecase.outbound.UpdateFoodTruckPort
import com.example.demo.review.domain.Review
import com.example.demo.review.usecase.inbound.command.CreateReviewCommand
import com.example.demo.review.usecase.outbound.SaveReviewPort
import java.time.LocalDateTime

class CreateReviewService(
    private val saveReviewPort: SaveReviewPort,
    private val loadFoodTruckPort: LoadFoodTruckPort,
    private val updateFoodTruckPort: UpdateFoodTruckPort
) {
    fun createReview(command: CreateReviewCommand) {
        val review = Review(
            rating = command.rating,
            comment = command.comment,
            reviewDate = LocalDateTime.now(),
            userId = command.userId,
            foodTruckId = command.foodTruckId
        )

        val foodTruck = loadFoodTruckPort.loadFoodTruckById(command.foodTruckId)
        foodTruck.addReview()

        saveReviewPort.saveReview(review)
        updateFoodTruckPort.updateFoodTruck(foodTruck)
    }
}