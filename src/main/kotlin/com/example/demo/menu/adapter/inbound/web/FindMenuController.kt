package com.example.demo.menu.adapter.inbound.web

import com.example.demo.menu.adapter.inbound.payload.DetailMenuResponse
import com.example.demo.menu.usecase.inbound.query.FindMenuQuery
import com.example.demo.menu.usecase.inbound.service.FindMenuService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menus")
class FindMenuController(private val findMenuService: FindMenuService) {

    @GetMapping("/{menuId}")
    fun findMenuById(@PathVariable menuId: Long): ResponseEntity<DetailMenuResponse> {
        val findMenuQuery = FindMenuQuery(
            menuId = menuId
        )

        findMenuService.findMenuById(findMenuQuery).let { menu ->
            return ResponseEntity.ok(
                DetailMenuResponse(
                    menuId = menu.menuId!!,
                    name = menu.name,
                    description = menu.description,
                    price = menu.price,
                    foodTruckId = menu.foodTruckId
                )
            )
        }
    }
}