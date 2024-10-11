package org.ksystem.app.di

import io.ktor.util.logging.*
import org.koin.dsl.module
import org.ksystem.app.domain.model.properties.AppProperties

fun totalAppModules(properties: AppProperties, logger: Logger) = module {
    // Pass all properties from AppProperties to DI
    single { properties }
    single { properties.database }
    single { properties.token }

    // Pass app logger to DI
    single { logger }

    includes(
        databaseModule,
        dataSourceModule,
        repositoryModule,
    )
}
