package org.ksystem.app.domain.repository

import org.ksystem.app.domain.model.Account

interface AuthRepository {
    suspend fun signIn(username: String, password: String): Result<Account>

    suspend fun signUp(username: String, password: String): Result<Account>

    suspend fun refreshToken(token: String): Result<RefreshedToken>

    suspend fun generateToken(account: Account): Result<String>

    data class RefreshedToken(
        val account: Account,
        val token: String,
    )
}