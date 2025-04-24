package org.ksystem.app.server.feature.auth

import io.ktor.resources.*
import org.ksystem.app.server.feature.BaseRoutes

@Resource("/auth")
class AuthRoute(
    @Suppress("unused") val parent: BaseRoutes = BaseRoutes()
) {
    @Resource("/signIn")
    class SignInRoute(
        @Suppress("unused") val parent: AuthRoute = AuthRoute()
    )

    @Resource("/signUp")
    class SignUpRoute(
        @Suppress("unused") val parent: AuthRoute = AuthRoute()
    )

    @Resource("/refresh")
    class RefreshTokenRoute(
        @Suppress("unused") val parent: AuthRoute = AuthRoute()
    )
}