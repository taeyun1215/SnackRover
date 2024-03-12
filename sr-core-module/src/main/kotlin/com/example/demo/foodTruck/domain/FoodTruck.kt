package com.example.demo.foodTruck.domain

import com.example.demo.user.domain.User

data class FoodTruck(
    val foodTruckId: Long? = null,
    var name: String,
    var foodType: FoodType,
    var operatingStatus: Boolean,
    var user: User
) {
    fun openForBusiness() {
        operatingStatus = true
    }

    fun closeForBusiness() {
        operatingStatus = false
    }
}