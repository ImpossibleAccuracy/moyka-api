package org.ksystem.app.server.feature.order.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.koin.ktor.ext.get
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.repository.OrderRepository
import org.ksystem.app.server.feature.order.OrderRoute
import org.ksystem.app.server.mapper.toDto
import org.ksystem.app.server.payload.request.CreateOrderRequest
import org.ksystem.app.server.security.requireAccount
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafePost

internal fun Routing.createOrderRoute() {
    authenticate {
        typeSafePost<OrderRoute.Create> {
            val result = createOrderRoute(
                account = call.requireAccount(),
                body = call.receive(),
                repository = call.get(),
            )

            call.respond(result)
        }
    }
}

private suspend inline fun createOrderRoute(
    account: AccountDomain,
    body: CreateOrderRequest,
    repository: OrderRepository,
) = endpoint {
    repository
        .create(
            account = account,
            serviceId = body.serviceId,
            address = body.address,
            contacts = body.contacts,
            deliveryDate = Instant
                .fromEpochMilliseconds(body.deliveryDate)
                .toLocalDateTime(TimeZone.UTC),
            paymentType = body.paymentType,
        )
        .toDto()
}
