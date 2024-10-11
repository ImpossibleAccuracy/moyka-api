package org.ksystem.app.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.ksystem.app.data.repository.AccountRepositoryImpl
import org.ksystem.app.data.repository.AuthRepositoryImpl
import org.ksystem.app.data.repository.PasswordManager
import org.ksystem.app.domain.repository.AccountRepository
import org.ksystem.app.domain.repository.AuthRepository

val repositoryModule = module {
    singleOf(::PasswordManager)
    singleOf(::AccountRepositoryImpl) bind AccountRepository::class
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
}
