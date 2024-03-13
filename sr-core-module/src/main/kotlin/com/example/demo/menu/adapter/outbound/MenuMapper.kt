package com.example.demo.menu.adapter.outbound

import com.example.demo.menu.domain.Menu
import com.example.entity.menu.MenuJpaEntity
import org.springframework.stereotype.Component

@Component
class MenuMapper {
    fun mapToDomainEntity(menuJpaEntity: MenuJpaEntity): Menu = Menu(
        menuId = menuJpaEntity.id,
        name = menuJpaEntity.name,
        description = menuJpaEntity.description,
        price = menuJpaEntity.price,
        foodTruckId = menuJpaEntity.foodTruckId
    )

    fun mapToJpaEntity(menu: Menu): MenuJpaEntity = MenuJpaEntity(
        name = menu.name,
        description = menu.description,
        price = menu.price,
        foodTruckId = menu.foodTruckId
    )
}