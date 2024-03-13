package com.example.demo.review.adapter.outbound

import com.example.demo.review.domain.Review
import com.example.review.ReviewJpaEntity
import com.example.demo.user.adapter.outbound.UserMapper
import org.springframework.stereotype.Component

@Component
class ReviewMapper(private val userMapper: UserMapper) {

    fun mapToDomainEntity(reviewJpaEntity: ReviewJpaEntity): Review = Review(
        reviewId = reviewJpaEntity.id,
        starRating = reviewJpaEntity.starRating,
        comment = reviewJpaEntity.comment,
        reviewDate = reviewJpaEntity.reviewDate,
        userId = reviewJpaEntity.userId,
        foodTruckId = reviewJpaEntity.foodTruckId
    )

    fun mapToJpaEntity(review: Review): ReviewJpaEntity = ReviewJpaEntity(
        starRating = review.starRating,
        comment = review.comment,
        reviewDate = review.reviewDate,
        userId = review.userId,
        foodTruckId = review.foodTruckId
    )

    fun mapToDomainEntites(reviewJpaEntities: List<ReviewJpaEntity>): List<Review> {
        return reviewJpaEntities.map { reviewJpaEntity ->
            Review(
                reviewId = reviewJpaEntity.id,
                starRating = reviewJpaEntity.starRating,
                comment = reviewJpaEntity.comment,
                reviewDate = reviewJpaEntity.reviewDate,
                userId = reviewJpaEntity.userId,
                foodTruckId = reviewJpaEntity.foodTruckId
            )
        }
    }
}