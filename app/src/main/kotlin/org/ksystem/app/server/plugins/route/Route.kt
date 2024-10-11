package org.ksystem.app.server.plugins.route

import org.ksystem.app.server.plugins.route.exceptionhandler.installExceptionHandler
import io.ktor.server.application.*
import io.ktor.server.resources.*

fun Application.configureRouting() {
    install(Resources)

    installExceptionHandler()
}

