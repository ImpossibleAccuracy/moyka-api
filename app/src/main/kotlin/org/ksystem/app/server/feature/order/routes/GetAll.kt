package org.ksystem.app.server.feature.order.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.ksystem.app.domain.exception.OperationRejectedException
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.model.security.RoleDomain
import org.ksystem.app.domain.repository.OrderRepository
import org.ksystem.app.server.feature.order.OrderRoute
import org.ksystem.app.server.mapper.toDto
import org.ksystem.app.server.security.requireAccount
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafeGet

internal fun Routing.getAllOrdersRoute() {
    authenticate {
        typeSafeGet<OrderRoute.All> {
            val result = getAllOrdersRoute(
                account = call.requireAccount(),
                repository = call.get(),
            )

            call.respond(result)
        }
    }
}

private suspend inline fun getAllOrdersRoute(
    account: AccountDomain,
    repository: OrderRepository,
) = endpoint {
    if (account.role != RoleDomain.ADMIN) {
        throw OperationRejectedException("You are not admin")
    }

    repository.getAll().map { it.toDto() }
}
