package com.example.entity.restArea

import jakarta.persistence.*

@Entity
@Table(name = "rest_areas")
class RestAreaJpaEntity(
    @Id
    @Column(name = "rest_area_code")
    val restAreaCode: Long,

    @Column(name = "rest_area_name")
    val restAreaName: String
)