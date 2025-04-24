package org.ksystem.app.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.ksystem.app.data.datasource.AccountDataSource
import org.ksystem.app.data.datasource.OrderDataSource
import org.ksystem.app.data.datasource.ServiceDataSource

val dataSourceModule = module {
    factoryOf(::AccountDataSource)
    factoryOf(::ServiceDataSource)
    factoryOf(::OrderDataSource)
}