package com.example.demo.foodTruck.domain

import com.example.demo.user.domain.User

data class FoodTruck(
    val id: Long? = null, // 푸드트럭의 고유 식별자입니다.
    var name: String, // 푸드트럭의 이름입니다.
    var foodType: FoodType, // 푸드트럭에서 제공하는 음식의 종류를 나타내는 enum 필드
    var operatingStatus: Boolean, // true: 영업 중, false: 영업 종료
    var starRating: Float, // 푸드트럭에 대한 평균 평점입니다.
    var reviewCount: Int, // 푸드트럭에 대한 리뷰 개수입니다.
    var user: User  // 이 푸드트럭의 주인. 여기서 User도 도메인 엔터티로 가정합니다.
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