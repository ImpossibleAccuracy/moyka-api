package org.ksystem.app.server.feature.auth.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.ksystem.app.domain.exception.InvalidInputException
import org.ksystem.app.domain.exception.OperationRejectedException
import org.ksystem.app.domain.repository.AuthRepository
import org.ksystem.app.server.feature.auth.AuthRoute
import org.ksystem.app.server.payload.response.AuthResponse
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafePost

private const val TOKEN_PREFIX = "Bearer "

internal fun Routing.refreshToken() {
    typeSafePost<AuthRoute.RefreshTokenRoute> {
        val token = call.request.headers["Authorization"]
            ?: throw OperationRejectedException("Unauthorized")

        if (!token.startsWith(TOKEN_PREFIX)) {
            throw InvalidInputException("Token must starts with \"$TOKEN_PREFIX\"")
        }

        val result = refreshTokenRoute(
            token = token.substring(TOKEN_PREFIX.length),
            authRepository = call.get(),
        )

        call.respond(result)
    }
}

suspend fun refreshTokenRoute(
    token: String,
    authRepository: AuthRepository,
): AuthResponse = endpoint {
    authRepository
        .refreshToken(token)
        .getOrThrow()
        .let {
            AuthResponse(
                id = it.account.idValue,
                token = it.token,
            )
        }
}
