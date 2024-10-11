package org.ksystem.app.server.feature.acount

import io.ktor.resources.*
import org.ksystem.app.server.feature.BaseRoutes

@Resource("/account")
class AccountRoute(
    @Suppress("unused") val parent: BaseRoutes = BaseRoutes()
) {
    @Resource("/me")
    class MeRoute(
        @Suppress("unused") val parent: AccountRoute = AccountRoute()
    )
}