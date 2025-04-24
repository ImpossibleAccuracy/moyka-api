package org.ksystem.app.server.feature.auth.routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.ksystem.app.domain.repository.AuthRepository
import org.ksystem.app.server.feature.auth.AuthRoute
import org.ksystem.app.server.payload.request.SignUpRequest
import org.ksystem.app.server.payload.response.AuthResponse
import org.ksystem.app.server.utils.endpoint
import org.ksystem.app.server.utils.typeSafePost

internal fun Routing.signUpRoute() {
    typeSafePost<AuthRoute.SignUpRoute> {
        val result = signUpRoute(
            body = call.receive(),
            authRepository = call.get(),
        )

        call.respond(result)
    }
}

suspend fun signUpRoute(
    body: SignUpRequest,
    authRepository: AuthRepository,
): AuthResponse = endpoint {
    val user = authRepository
        .signUp(
            username = body.username,
            password = body.password,
            firstName = body.firstName,
            middleName = body.middleName ?: "",
            lastName = body.lastName,
            email = body.email,
            phone = body.phone,
        )
        .getOrThrow()

    AuthResponse(
        id = user.idValue,
        token = authRepository.generateToken(user).getOrThrow(),
    )
}
