package org.ksystem.app.server.feature

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.ksystem.app.server.feature.acount.accountRoutes
import org.ksystem.app.server.feature.auth.authRoutes

fun Application.setupApiRoutes() {
    routing {
        authRoutes()
        accountRoutes()
    }
}
