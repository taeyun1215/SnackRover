package com.example.menu

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
//    var photoUrl: String? = null, // 메뉴의 사진 URL입니다.

    var foodTruckId: Long // 리뷰 대상 푸드트럭에 대한 Id참조입니다.
)