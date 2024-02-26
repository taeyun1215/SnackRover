package com.example.demo.menu.infrastructure

import com.example.demo.foodTruck.infrastructure.FoodTruckJpaEntity
import jakarta.persistence.*

@Entity
@Table(name = "menus")
class MenuJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // 메뉴의 고유 식별자입니다.

    var name: String, // 메뉴의 이름입니다.
    var description: String, // 메뉴에 대한 설명입니다.
    var price: Float, // 메뉴의 가격입니다.

    @ManyToOne
    @JoinColumn(name = "food_truck_id")
    var foodTruck: FoodTruckJpaEntity // 이 메뉴를 제공하는 푸드트럭에 대한 참조입니다.
)