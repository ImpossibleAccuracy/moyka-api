package org.ksystem.app.server.feature.order.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.ksystem.app.domain.exception.OperationRejectedException
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.model.security.RoleDomain
import org.ksystem.app.domain.repository.OrderRepository
import org.ksystem.app.domain.utils.require
import org.ksystem.app.server.feature.order.OrderRoute
import org.ksystem.app.server.payload.request.UpdateOrderStatusRequest
import org.ksystem.app.server.security.requireAccount
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafePut

internal fun Routing.updateOrderStatusRoute() {
    authenticate {
        typeSafePut<OrderRoute.UpdateStatus> {
            val result = updateOrderStatusRoute(
                account = call.requireAccount(),
                body = call.receive(),
                repository = call.get(),
            )

            call.respond(HttpStatusCode.NoContent, result)
        }
    }
}

private suspend inline fun updateOrderStatusRoute(
    account: AccountDomain,
    body: UpdateOrderStatusRequest,
    repository: OrderRepository,
) = endpoint {
    if (account.role != RoleDomain.ADMIN) {
        throw OperationRejectedException("You are not admin")
    }

    val order = repository.getById(body.orderId).require()

    repository.updateStatus(
        account = account,
        order = order,
        newStatus = body.status,
        rejectReason = body.rejectReason,
    )
}
