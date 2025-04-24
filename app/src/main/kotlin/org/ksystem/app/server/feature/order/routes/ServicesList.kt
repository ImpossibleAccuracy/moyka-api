package org.ksystem.app.server.feature.order.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.ksystem.app.domain.repository.ServicesRepository
import org.ksystem.app.server.feature.order.OrderRoute
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafeGet

internal fun Routing.serviceListRoute() {
    typeSafeGet<OrderRoute.Services> {
        val result = serviceListRoute(
            repository = call.get(),
        )

        call.respond(result)
    }
}

private suspend inline fun serviceListRoute(
    repository: ServicesRepository,
) = endpoint {
    repository.getAll()
}
