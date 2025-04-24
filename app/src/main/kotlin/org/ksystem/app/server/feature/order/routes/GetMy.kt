package org.ksystem.app.server.feature.order.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.repository.OrderRepository
import org.ksystem.app.server.feature.order.OrderRoute
import org.ksystem.app.server.security.requireAccount
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafeGet

internal fun Routing.getMyOrdersRoute() {
    authenticate {
        typeSafeGet<OrderRoute.My> {
            val result = getMyOrdersRoute(
                account = call.requireAccount(),
                repository = call.get(),
            )

            call.respond(result)
        }
    }
}

private suspend inline fun getMyOrdersRoute(
    account: AccountDomain,
    repository: OrderRepository,
) = endpoint {
    repository.getByAccount(account)
}
