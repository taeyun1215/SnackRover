package com.example.demo.foodTruck.adapter.outbound

import com.example.demo.foodTruck.domain.FoodTruck
import com.example.foodTruck.FoodTruckJpaEntity
import com.example.demo.user.adapter.outbound.UserMapper
import org.springframework.stereotype.Component

@Component
class FoodTruckMapper(
    private val userMapper: UserMapper
) {
    fun mapToDomainEntity(foodTruckJpaEntity: FoodTruckJpaEntity): FoodTruck = FoodTruck(
        foodTruckId = foodTruckJpaEntity.id,
        name = foodTruckJpaEntity.name,
        foodType = foodTruckJpaEntity.foodType,
        operatingStatus = foodTruckJpaEntity.operatingStatus,
        user = userMapper.mapToDomainEntity(foodTruckJpaEntity.userJpaEntity)
    )

    fun mapToJpaEntity(foodTruck: FoodTruck): FoodTruckJpaEntity = FoodTruckJpaEntity(
        name = foodTruck.name,
        foodType = foodTruck.foodType,
        userJpaEntity = userMapper.mapToJpaEntity(foodTruck.user)
    )

    fun mapToJpaEntityForUpdate(foodTruck: FoodTruck): FoodTruckJpaEntity = FoodTruckJpaEntity(
        id = foodTruck.foodTruckId,
        name = foodTruck.name,
        foodType = foodTruck.foodType,
        operatingStatus = foodTruck.operatingStatus,
        userJpaEntity = userMapper.mapToJpaEntity(foodTruck.user)
    )
}
