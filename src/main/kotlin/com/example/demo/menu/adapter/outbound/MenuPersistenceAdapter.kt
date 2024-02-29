package com.example.demo.menu.adapter.outbound

import com.example.demo.menu.domain.Menu
import com.example.demo.menu.infrastructure.MenuJpaEntity
import com.example.demo.menu.infrastructure.MenuRepository
import com.example.demo.menu.usecase.outbound.SaveMenuPort
import org.springframework.stereotype.Component

@Component
class MenuPersistenceAdapter(
    private val menuRepository: MenuRepository,
    private val menuMapper: MenuMapper
) : SaveMenuPort {

    override fun saveMenu(menu: Menu) {
        menuRepository.save(menuMapper.mapToJpaEntity(menu))
    }
}