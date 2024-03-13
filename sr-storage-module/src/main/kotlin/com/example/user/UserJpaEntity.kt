package com.example.user

import com.example.foodTruck.FoodTruckJpaEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // 사용자의 고유 식별자입니다.

    var username: String, // 사용자 이름입니다.
    var password: String, // 사용자 비밀번호입니다.

    @Embedded
    var email: Email, // 사용자 이메일 주소입니다.

    @Enumerated(EnumType.STRING)
    var userRole: UserRole, // 사용자 권한입니다.

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "food_truck_id", referencedColumnName = "id")
    var foodtruck: FoodTruckJpaEntity? = null
)