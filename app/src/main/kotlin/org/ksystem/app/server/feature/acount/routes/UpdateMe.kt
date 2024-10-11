package org.ksystem.app.server.feature.acount.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.ksystem.app.domain.model.Account
import org.ksystem.app.domain.repository.AccountRepository
import org.ksystem.app.server.feature.acount.AccountRoute
import org.ksystem.app.server.mapper.toDto
import org.ksystem.app.server.payload.dto.AccountDto
import org.ksystem.app.server.payload.request.UpdateAccountRequest
import org.ksystem.app.server.security.requireAccount
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafePut

internal fun Routing.updateMeRoute() {
    authenticate {
        typeSafePut<AccountRoute.MeRoute> {
            val account = call.requireAccount()

            val result = updateMeRoute(
                account = account,
                data = call.receive(),
                accountRepository = call.get()
            )

            call.respond(result)
        }
    }
}

suspend fun updateMeRoute(
    account: Account,
    data: UpdateAccountRequest,
    accountRepository: AccountRepository,
): AccountDto = endpoint {
    accountRepository
        .updateAccount(
            id = account.idValue,
            username = data.username
        )
        .getOrThrow()
        .toDto()
}
