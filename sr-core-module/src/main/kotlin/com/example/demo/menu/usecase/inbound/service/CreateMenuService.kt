package com.example.demo.menu.usecase.inbound.service

import com.example.demo.menu.domain.Menu
import com.example.demo.menu.usecase.inbound.command.CreateMenuCommand
import com.example.demo.menu.usecase.outbound.SaveMenuPort
import org.springframework.stereotype.Service

@Service
class CreateMenuService(private val saveMenuPort: SaveMenuPort) {

    fun createMenu(command: CreateMenuCommand) {
        val menu = Menu(
            name = command.name,
            description = command.description,
            price = command.price,
            foodTruckId = command.foodTruckId
        )
        saveMenuPort.saveMenu(menu)
    }
}