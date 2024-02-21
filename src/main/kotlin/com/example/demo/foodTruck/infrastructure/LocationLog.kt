package com.example.demo.foodTruck.infrastructure

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "location_logs")
class LocationLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val latitude: Float, // 푸드트럭의 위치(위도)
    val longitude: Float, // 푸드트럭의 위치(경도)
    val timestamp: LocalDateTime = LocalDateTime.now(), // 위치 정보가 기록된 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_truck_id")
    val foodTruck: FoodTruckJpaEntity
)