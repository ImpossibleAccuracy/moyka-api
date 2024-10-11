package org.ksystem.app.domain.model.properties

data class TokenProperties(
    val secret: String,
    val issuer: String,
    val audience: String,
    val ttl: Long,
)
