package com.example.demo.menu.usecase.outbound

import com.example.demo.menu.domain.Menu

interface LoadMenuPort {
    fun loadMenuById(menuId: Long): Menu
}