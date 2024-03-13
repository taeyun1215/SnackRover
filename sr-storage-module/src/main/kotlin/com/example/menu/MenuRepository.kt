package com.example.menu

import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<MenuJpaEntity, Long> {
}