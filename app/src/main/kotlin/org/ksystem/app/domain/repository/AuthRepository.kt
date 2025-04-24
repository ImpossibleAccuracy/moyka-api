package org.ksystem.app.domain.repository

import org.ksystem.app.domain.model.AccountDomain

interface AuthRepository {
    suspend fun signIn(username: String, password: String): Result<AccountDomain>

    suspend fun signUp(
        username: String,
        password: String,
        firstName: String,
        middleName: String,
        lastName: String,
        email: String,
        phone: String,
    ): Result<AccountDomain>

    suspend fun refreshToken(token: String): Result<RefreshedToken>

    suspend fun generateToken(account: AccountDomain): Result<String>

    data class RefreshedToken(
        val account: AccountDomain,
        val token: String,
    )
}