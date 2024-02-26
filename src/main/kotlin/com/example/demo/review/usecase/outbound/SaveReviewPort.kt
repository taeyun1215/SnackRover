package com.example.demo.review.usecase.outbound

import com.example.demo.review.domain.Review

interface SaveReviewPort {
    fun saveReview(review: Review)
}