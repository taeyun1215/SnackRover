package com.example.user

enum class UserRole {
    OWNER,
    CUSTOMER;

    companion object {
        fun validationUserRole(value: String): UserRole {
            return try {
                valueOf(value.uppercase())
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("Invalid user role: $value")
            }
        }
    }
}
