package com.example.demo.menu.usecase.outbound

import com.example.demo.menu.domain.Menu

interface SaveMenuPort {
    fun saveMenu(menu: Menu)
}