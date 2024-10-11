package org.ksystem.app.server.feature.acount

import io.ktor.server.routing.*
import org.ksystem.app.server.feature.acount.routes.deleteMeRoute
import org.ksystem.app.server.feature.acount.routes.getMeRoute
import org.ksystem.app.server.feature.acount.routes.updateMeRoute

fun Routing.accountRoutes() {
    getMeRoute()
    updateMeRoute()
    deleteMeRoute()
}
