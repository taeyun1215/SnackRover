package com.example.demo.user.domain

data class User(
    val userId: Long? = null,
    val name: String,
    val password: String,
    val email: Email
) {
    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(
            password.matches(
                Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
            )
        ) {"Password must be at least 8 characters long and include a mix of upper and lower case letters, numbers, and special characters"}
    }
}