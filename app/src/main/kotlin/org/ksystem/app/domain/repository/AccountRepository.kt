package org.ksystem.app.domain.repository

import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.model.security.RoleDomain

interface AccountRepository {
    suspend fun createAccount(
        username: String,
        password: String,
        firstName: String,
        middleName: String,
        lastName: String,
        email: String,
        phone: String,
        role: RoleDomain,
    ): Result<AccountDomain>

    suspend fun getAccount(id: Int): Result<AccountDomain>

    suspend fun getAccount(username: String): Result<AccountDomain>

    suspend fun existsByUsername(username: String): Boolean

    suspend fun updateAccount(id: Int, username: String): Result<AccountDomain>

    suspend fun deleteAccount(id: Int): Result<Unit>
}