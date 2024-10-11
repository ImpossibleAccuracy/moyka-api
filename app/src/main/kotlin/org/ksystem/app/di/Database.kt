package org.ksystem.app.di

import org.koin.dsl.module
import org.ksystem.app.data.database.setup.createDatabase

val databaseModule = module(createdAtStart = true) {
    single {
        createDatabase(
            properties = get(),
        )
    }
}
