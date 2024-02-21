package com.example.demo.foodTruck.adapter.inbound.payload

data class CreateFoodTruckRequest(
    val name: String,
    val foodType: String // 클라이언트로부터 문자열 형태로 받고, 서버에서는 이를 enum으로 변환합니다.
)