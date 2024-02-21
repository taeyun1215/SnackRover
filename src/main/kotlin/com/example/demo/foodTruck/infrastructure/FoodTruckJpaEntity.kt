package com.example.demo.foodTruck.infrastructure

import com.example.demo.foodTruck.domain.FoodType
import com.example.demo.menu.MenuJpaEntity
import com.example.demo.review.ReviewJpaEntity
import com.example.demo.user.infrastructure.UserJpaEntity
import jakarta.persistence.*

@Entity
@Table(name = "food_trucks")
class FoodTruckJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // 푸드트럭의 고유 식별자입니다.

    var name: String, // 푸드트럭의 이름입니다.

    @Enumerated(EnumType.STRING) // Enum 값을 문자열로 데이터베이스에 저장
    var foodType: FoodType, // 푸드트럭에서 제공하는 음식의 종류를 나타내는 enum 필드

    var operatingHours: String, // 푸드트럭의 영업 시간입니다.
    var priceRange: String, // 푸드트럭에서 제공하는 음식의 가격 범위입니다.
    var rating: Float, // 푸드트럭에 대한 평균 평점입니다.
    var photoUrl: String, // 푸드트럭의 사진 URL입니다.
    var bankAccount: String, // 푸드트럭의 은행 계좌입니다.

    @OneToMany(mappedBy = "foodTruck", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val locationLogs: MutableList<LocationLog> = mutableListOf(), // 이 푸드트럭에 대한 위치 로그입니다.

    @OneToOne(mappedBy = "foodtruck", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var user: UserJpaEntity? = null,  // 이 푸드트럭의 주인 입니다.

    @OneToMany(mappedBy = "foodTruck", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var reviews: MutableList<ReviewJpaEntity> = mutableListOf(), // 이 푸드트럭에 대한 리뷰 목록입니다.

    @OneToMany(mappedBy = "foodTruck", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var menus: MutableList<MenuJpaEntity> = mutableListOf() // 이 푸드트럭에서 제공하는 메뉴 목록입니다.
)