package com.example.demo.menu.usecase.inbound.service

import com.example.demo.menu.domain.Menu
import com.example.demo.menu.usecase.inbound.query.FindMenuQuery
import com.example.demo.menu.usecase.outbound.LoadMenuPort
import org.springframework.stereotype.Service

@Service
class FindMenuService(
    private val loadMenuPort: LoadMenuPort
) {
    fun findMenuById(query: FindMenuQuery): Menu {
        return loadMenuPort.loadMenuById(query.menuId)
    }
}