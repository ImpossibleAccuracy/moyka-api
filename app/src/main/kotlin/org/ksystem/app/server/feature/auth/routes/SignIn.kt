package org.ksystem.app.server.feature.auth.routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.ksystem.app.domain.repository.AuthRepository
import org.ksystem.app.server.feature.auth.AuthRoute
import org.ksystem.app.server.payload.request.SignInRequest
import org.ksystem.app.server.payload.response.AuthResponse
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafePost

internal fun Routing.signInRoute() {
    typeSafePost<AuthRoute.SignInRoute> {
        val result = signInRoute(
            body = call.receive(),
            authRepository = call.get(),
        )

        call.respond(result)
    }
}

suspend fun signInRoute(
    body: SignInRequest,
    authRepository: AuthRepository,
): AuthResponse = endpoint {
    val user = authRepository
        .signIn(body.username, body.password)
        .getOrThrow()

    AuthResponse(
        id = user.idValue,
        token = authRepository.generateToken(user).getOrThrow(),
    )
}
