package com.example.demo.user.domain

import jakarta.persistence.Embeddable

@Embeddable
data class Email(
    val address: String
) {
    init {
        require(
            address.matches(
                Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
            )
        ) { "Invalid email format" }
    }
}