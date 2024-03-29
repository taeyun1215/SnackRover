package com.example.entity.foodTruck

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationLogRepository: JpaRepository<LocationLog, Long> {
}