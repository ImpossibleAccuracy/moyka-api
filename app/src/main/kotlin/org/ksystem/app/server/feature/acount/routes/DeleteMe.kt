package org.ksystem.app.server.feature.acount.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.repository.AccountRepository
import org.ksystem.app.server.feature.acount.AccountRoute
import org.ksystem.app.server.security.requireAccount
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafePut

internal fun Routing.deleteMeRoute() {
    authenticate {
        typeSafePut<AccountRoute.MeRoute> {
            val account = call.requireAccount()

            deleteMeRoute(
                account = account,
                accountRepository = call.get()
            )

            call.respond(HttpStatusCode.NoContent)
        }
    }
}

suspend fun deleteMeRoute(
    account: AccountDomain,
    accountRepository: AccountRepository,
) = endpoint {
    accountRepository
        .deleteAccount(id = account.idValue)
        .getOrThrow()
}
