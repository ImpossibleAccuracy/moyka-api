package org.ksystem.app.server.feature.auth

import io.ktor.server.routing.*
import org.ksystem.app.server.feature.auth.routes.refreshToken
import org.ksystem.app.server.feature.auth.routes.signInRoute
import org.ksystem.app.server.feature.auth.routes.signUpRoute

fun Routing.authRoutes() {
    signInRoute()
    signUpRoute()
    refreshToken()
}
