package com.example.demo.review

import com.example.demo.foodTruck.infrastructure.FoodTruckJpaEntity
import com.example.demo.user.infrastructure.UserJpaEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "reviews")
class ReviewJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // 리뷰의 고유 식별자입니다.

    var rating: Int, // 리뷰에 부여된 별점입니다.
    var comment: String, // 리뷰 코멘트입니다.
    var reviewDate: LocalDateTime, // 리뷰가 작성된 날짜와 시간입니다.

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: UserJpaEntity, // 리뷰를 작성한 사용자에 대한 참조입니다.

    @ManyToOne
    @JoinColumn(name = "food_truck_id")
    var foodTruck: FoodTruckJpaEntity // 리뷰 대상 푸드트럭에 대한 참조입니다.
)