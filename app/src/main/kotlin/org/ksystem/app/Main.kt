package org.ksystem.app

import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.ksystem.app.server.feature.setupApiRoutes
import org.ksystem.app.server.plugins.koin.configureKoin
import org.ksystem.app.server.plugins.monitoring.configureMonitoring
import org.ksystem.app.server.plugins.route.configureRouting
import org.ksystem.app.server.plugins.security.configureSecurity
import org.ksystem.app.server.plugins.serialization.configureSerialization
import org.ksystem.app.server.properties.toAppProperties

fun main(args: Array<String>) {
    EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    val properties = environment.toAppProperties()

    configureKoin(properties)
    configureMonitoring()
    configureSerialization()
    configureSecurity()
    configureRouting(properties)

    setupApiRoutes()
}