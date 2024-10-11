package org.ksystem.app.server.plugins.koin

import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.ksystem.app.di.totalAppModules
import org.ksystem.app.domain.model.properties.AppProperties

fun Application.configureKoin(properties: AppProperties) {
    install(Koin) {
        modules(
            totalAppModules(properties, log),
        )
    }
}