package com.example.demo.menu.adapter.inbound.web

import com.example.demo.menu.adapter.inbound.payload.CommonMenuResponse
import com.example.demo.menu.adapter.inbound.payload.CreateMenuRequest
import com.example.demo.menu.usecase.inbound.command.CreateMenuCommand
import com.example.demo.menu.usecase.inbound.service.CreateMenuService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menus")
class CreateMenuController(private val createMenuService: CreateMenuService) {

    @PostMapping
    fun createMenu(@RequestBody request: CreateMenuRequest): ResponseEntity<CommonMenuResponse> {
        val createMenuCommand = CreateMenuCommand(
            name = request.name,
            description = request.description,
            price = request.price,
            foodTruckId = request.foodTruckId
        )

        createMenuService.createMenu(createMenuCommand)
        return ResponseEntity.ok(CommonMenuResponse("메뉴가 등록되었습니다."))
    }
}