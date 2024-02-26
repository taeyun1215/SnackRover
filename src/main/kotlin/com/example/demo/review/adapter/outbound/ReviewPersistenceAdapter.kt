package com.example.demo.review.adapter.outbound

import com.example.demo.review.domain.Review
import com.example.demo.review.infrastructure.ReviewRepository
import com.example.demo.review.usecase.inbound.query.FindReviewQuery
import com.example.demo.review.usecase.outbound.LoadReviewPort
import com.example.demo.review.usecase.outbound.SaveReviewPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
@Transactional
class ReviewPersistenceAdapter(
    private val reviewRepository: ReviewRepository,
    private val reviewMapper: ReviewMapper
) : SaveReviewPort, LoadReviewPort {

    override fun saveReview(review: Review) {
        reviewRepository.save(reviewMapper.mapToJpaEntity(review))
    }

    override fun loadReviewsByFoodTruckId(query: FindReviewQuery): List<Review>? {
        return reviewRepository.findByFoodTruckId(query.foodTruckId)?.map { reviewMapper.mapToDomainEntity(it) }
    }
}
