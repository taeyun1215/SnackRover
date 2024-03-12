package com.example.demo.foodTruck.domain

enum class FoodType {
    KOREAN, // 한식
    CHINESE, // 중식
    JAPANESE, // 일식
    WESTERN; // 양식

    companion object {
        fun validationFoodType(value: String): FoodType {
            return try {
                FoodType.valueOf(value.uppercase())
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("Invalid food type: $value")
            }
        }
    }
}