package org.ksystem.app.domain.model.properties

data class DatabaseProperties(
    val url: String,
    val user: String,
    val password: String,
    val poolSize: Int,
)