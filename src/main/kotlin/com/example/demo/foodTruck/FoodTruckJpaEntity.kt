package com.example.demo.foodTruck

import com.example.demo.menu.MenuJpaEntity
import com.example.demo.review.ReviewJpaEntity
import jakarta.persistence.*

@Entity
@Table(name = "food_trucks")
data class FoodTruckJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // 푸드트럭의 고유 식별자입니다.

    var name: String, // 푸드트럭의 이름입니다.
    var foodType: String, // 푸드트럭에서 제공하는 음식의 종류입니다.
    var latitude: Float, // 푸드트럭의 위치(위도)입니다.
    var longitude: Float, // 푸드트럭의 위치(경도)입니다.
    var operatingHours: String, // 푸드트럭의 영업 시간입니다. 더 복잡한 시간 처리가 필요하면 별도의 클래스를 고려해야 합니다.
    var priceRange: String, // 푸드트럭에서 제공하는 음식의 가격 범위입니다.
    var rating: Float, // 푸드트럭에 대한 평균 평점입니다.
    var photoUrl: String, // 푸드트럭의 사진 URL입니다.

    @OneToMany(mappedBy = "foodTruckJpaEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    var reviewJpaEntities: List<ReviewJpaEntity> = mutableListOf(), // 이 푸드트럭에 대한 리뷰 목록입니다.

    @OneToMany(mappedBy = "foodTruckJpaEntity", cascade = [CascadeType.ALL], orphanRemoval = true)
    var menus: List<MenuJpaEntity> = mutableListOf() // 이 푸드트럭에서 제공하는 메뉴 목록입니다.
)