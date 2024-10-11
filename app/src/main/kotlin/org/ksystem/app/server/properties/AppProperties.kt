package org.ksystem.app.server.properties

import io.ktor.server.application.*
import org.ksystem.app.domain.model.properties.AppProperties
import org.ksystem.app.domain.model.properties.DatabaseProperties
import org.ksystem.app.domain.model.properties.TokenProperties

fun ApplicationEnvironment.toAppProperties() = AppProperties(
    token = TokenProperties(
        secret = config.property("app.token.secret").getString(),
        issuer = config.property("app.token.issuer").getString(),
        audience = config.property("app.token.audience").getString(),
        ttl = config.property("app.token.ttl").getString().toLong(),
    ),
    database = DatabaseProperties(
        url = config.property("app.database.url").getString(),
        user = config.property("app.database.user").getString(),
        password = config.property("app.database.password").getString(),
        poolSize = config.property("app.database.poolSize").getString().toInt(),
    ),
)
