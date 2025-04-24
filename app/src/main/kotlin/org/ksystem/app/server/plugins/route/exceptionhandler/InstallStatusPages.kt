package org.ksystem.app.server.plugins.route.exceptionhandler

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.util.logging.*
import org.ksystem.app.domain.exception.ServiceException

fun Application.installExceptionHandler() {
    install(StatusPages) {
        exception<ServiceException> { call, cause ->
            call.respond(
                HttpStatusCode.fromValue(cause.status),
                ErrorResponse(
                    message = cause.localizedMessage ?: cause.message!!
                )
            )
        }

        exception<BadRequestException> { call, cause ->
            if (call.application.developmentMode) {
                call.application.log.error(cause)
            }

            call.respond(
                HttpStatusCode.BadRequest,
                ErrorResponse(
                    message = cause.localizedMessage ?: cause.message ?: "No error message"
                )
            )
        }

        exception<Throwable> { call, cause ->
            call.application.log.error(cause)

            call.respond(
                HttpStatusCode.InternalServerError,
                ErrorResponse(
                    message = cause.localizedMessage ?: cause.message ?: "No error message"
                )
            )
        }
    }
}
