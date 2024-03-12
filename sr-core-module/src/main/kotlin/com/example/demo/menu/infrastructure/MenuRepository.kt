package com.example.demo.menu.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<MenuJpaEntity, Long> {
}