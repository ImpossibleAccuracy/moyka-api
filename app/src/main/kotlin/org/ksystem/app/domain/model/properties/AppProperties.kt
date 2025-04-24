package org.ksystem.app.domain.model.properties

data class AppProperties(
    val server: ServerProperties,
    val token: TokenProperties,
    val database: DatabaseProperties,
)
