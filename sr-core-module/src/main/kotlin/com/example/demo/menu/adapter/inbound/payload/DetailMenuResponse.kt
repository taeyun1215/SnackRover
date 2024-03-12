package com.example.demo.menu.adapter.inbound.payload

data class DetailMenuResponse(
    val menuId: Long,
    val name: String,
    val description: String,
    val price: Float
)