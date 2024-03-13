package com.example.entity.foodTruck

import com.example.foodTruck.FoodType
import com.example.entity.user.UserJpaEntity
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

    var operatingStatus: Boolean = false, // true: 영업 중, false: 영업 종료
//    var photoUrl: String? = null, // 푸드트럭의 사진 URL입니다.
//    var bankAccount: String? = null, // 푸드트럭의 은행 계좌입니다.

    @OneToOne(mappedBy = "foodtruck", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var userJpaEntity: UserJpaEntity,  // 이 푸드트럭의 주인 입니다.
)