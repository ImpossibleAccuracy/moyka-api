package org.ksystem.app.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.ksystem.app.data.repository.*
import org.ksystem.app.domain.repository.AccountRepository
import org.ksystem.app.domain.repository.AuthRepository
import org.ksystem.app.domain.repository.OrderRepository
import org.ksystem.app.domain.repository.ServicesRepository

val repositoryModule = module {
    singleOf(::PasswordManager)
    singleOf(::AccountRepositoryImpl) bind AccountRepository::class
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
    singleOf(::OrderRepositoryImpl) bind OrderRepository::class
    singleOf(::ServicesRepositoryImpl) bind ServicesRepository::class
}
