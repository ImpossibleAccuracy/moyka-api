package org.ksystem.app.domain.model.security

enum class Role(
    val roleName: String,
) {
    USER("User"),

    ADMIN("Admin"),
}