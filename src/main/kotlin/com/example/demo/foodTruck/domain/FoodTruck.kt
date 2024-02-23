package com.example.demo.foodTruck.domain

import com.example.demo.user.domain.User

data class FoodTruck(
    val id: Long? = null,
    var name: String,
    var foodType: FoodType,
    var operatingStatus: Boolean,
    var starRating: Float,
    var reviewCount: Int,
    var user: User
) {
    fun openForBusiness() {
        operatingStatus = true
    }

    fun closeForBusiness() {
        operatingStatus = false
    }

    fun updateStarRating(newRating: Float) {
        // 새 평점을 계산하는 로직을 추가할 수 있습니다. 예를 들어, 리뷰 개수와 새 평점을 기반으로 평균을 다시 계산합니다.
        // 이 예제에서는 단순화를 위해 직접 할당합니다.
        starRating = newRating
    }

    fun addReview() {
        // 리뷰가 추가될 때마다 리뷰 개수를 증가시킵니다.
        reviewCount++
    }
}