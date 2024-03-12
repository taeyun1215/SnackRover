package com.example.demo.menu.adapter.outbound

import com.example.demo.menu.domain.Menu
import com.example.demo.menu.infrastructure.MenuRepository
import com.example.demo.menu.usecase.outbound.LoadMenuPort
import com.example.demo.menu.usecase.outbound.SaveMenuPort
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component

@Component
class MenuPersistenceAdapter(
    private val menuRepository: MenuRepository,
    private val menuMapper: MenuMapper
) : SaveMenuPort, LoadMenuPort {

    override fun saveMenu(menu: Menu) {
        menuRepository.save(menuMapper.mapToJpaEntity(menu))
    }

    override fun loadMenuById(menuId: Long): Menu {
        return menuMapper.mapToDomainEntity(
            menuRepository.findById(menuId).orElseThrow {
                EntityNotFoundException("FoodTruck not found with id: $menuId")
            }
        )
    }
}