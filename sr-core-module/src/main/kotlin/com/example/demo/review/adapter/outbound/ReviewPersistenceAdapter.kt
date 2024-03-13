package com.example.demo.review.adapter.outbound

import com.example.demo.review.domain.Review
import com.example.review.ReviewRepository
import com.example.demo.review.usecase.inbound.query.FindReviewQuery
import com.example.demo.review.usecase.outbound.LoadReviewPort
import com.example.demo.review.usecase.outbound.SaveReviewPort
import com.example.demo.user.usecase.outbound.LoadUserPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
@Transactional
class ReviewPersistenceAdapter(
    private val reviewRepository: ReviewRepository,
    private val loadUserPort: LoadUserPort,
    private val reviewMapper: ReviewMapper
) : SaveReviewPort, LoadReviewPort {

    override fun saveReview(review: Review) {
        reviewRepository.save(reviewMapper.mapToJpaEntity(review))
    }

    override fun loadReviewsByFoodTruckId(query: FindReviewQuery): List<Review> {
        reviewRepository.findByFoodTruckId(query.foodTruckId)?.let {
            return reviewMapper.mapToDomainEntites(it)
        } ?: return emptyList()
    }
}
