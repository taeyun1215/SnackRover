package com.example.entity.restArea

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RestAreaRepository: JpaRepository<RestAreaJpaEntity, Long> {
}