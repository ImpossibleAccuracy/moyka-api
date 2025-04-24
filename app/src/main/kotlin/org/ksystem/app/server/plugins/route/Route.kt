package org.ksystem.app.server.plugins.route

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.resources.*
import org.ksystem.app.domain.model.properties.AppProperties
import org.ksystem.app.server.plugins.route.exceptionhandler.installExceptionHandler

fun Application.configureRouting(properties: AppProperties) {
    install(Resources)

    installExceptionHandler()

    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowHeader(HttpHeaders.Authorization)
        allowHeader(HttpHeaders.AccessControlAllowOrigin)
        allowNonSimpleContentTypes = true
        allowCredentials = true
        allowSameOrigin = true
        allowHost(properties.server.frontendHost, listOf("http", "https"))
    }
}

