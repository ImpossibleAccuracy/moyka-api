package org.ksystem.app.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.ksystem.app.data.datasource.AccountDataSource
import org.ksystem.app.data.datasource.RoleDataSource

val dataSourceModule = module {
    factoryOf(::AccountDataSource)
    factoryOf(::RoleDataSource)
}