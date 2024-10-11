package org.ksystem.app.domain.repository

import org.ksystem.app.domain.model.Account

interface AccountRepository {
    suspend fun createAccount(
        username: String,
        password: String,
    ): Result<Account>

    suspend fun getAccount(id: Int): Result<Account>

    suspend fun getAccount(username: String): Result<Account>

    suspend fun existsByUsername(username: String): Boolean

    suspend fun updateAccount(id: Int, username: String): Result<Account>

    suspend fun deleteAccount(id: Int): Result<Unit>
}