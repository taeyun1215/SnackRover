package com.example.demo.review.adapter.outbound

import com.example.demo.review.domain.Review
import com.example.demo.review.infrastructure.ReviewJpaEntity
import com.example.demo.user.adapter.outbound.UserMapper
import com.example.demo.user.domain.User
import com.example.demo.user.infrastructure.UserJpaEntity
import org.springframework.stereotype.Component

@Component
class ReviewMapper(private val userMapper: UserMapper) {

    fun mapToDomainEntity(reviewJpaEntity: ReviewJpaEntity): Review = Review(
        reviewId = reviewJpaEntity.id,
        rating = reviewJpaEntity.rating,
        comment = reviewJpaEntity.comment,
        reviewDate = reviewJpaEntity.reviewDate,
        userId = reviewJpaEntity.userId,
        foodTruckId = reviewJpaEntity.foodTruckId
    )

    fun mapToJpaEntity(review: Review): ReviewJpaEntity = ReviewJpaEntity(
        rating = review.rating,
        comment = review.comment,
        reviewDate = review.reviewDate,
        userId = review.userId,
        foodTruckId = review.foodTruckId
    )
}