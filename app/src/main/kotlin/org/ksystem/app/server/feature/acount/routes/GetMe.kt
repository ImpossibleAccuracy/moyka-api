package org.ksystem.app.server.feature.acount.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ksystem.app.domain.model.Account
import org.ksystem.app.server.feature.acount.AccountRoute
import org.ksystem.app.server.mapper.toDto
import org.ksystem.app.server.security.requireAccount
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafeGet

internal fun Routing.getMeRoute() {
    authenticate {
        typeSafeGet<AccountRoute.MeRoute> {
            val account = call.requireAccount()

            val result = getMeRoute(account)

            call.respond(result)
        }
    }
}

suspend inline fun getMeRoute(account: Account) = endpoint { account.toDto() }
