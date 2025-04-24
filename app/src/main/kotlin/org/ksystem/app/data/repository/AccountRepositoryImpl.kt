package org.ksystem.app.data.repository

import org.ksystem.app.data.datasource.AccountDataSource
import org.ksystem.app.domain.exception.ResourceNotFoundException
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.repository.AccountRepository
import org.ksystem.app.domain.utils.require

class AccountRepositoryImpl(
    private val accountDataSource: AccountDataSource,
) : AccountRepository {
    override suspend fun createAccount(username: String, password: String): Result<AccountDomain> = runCatching {
        accountDataSource.save {
            this.username = username
            this.password = password
        }
    }

    override suspend fun getAccount(id: Int): Result<AccountDomain> = runCatching {
        accountDataSource.findById(id).require()
    }

    override suspend fun getAccount(username: String): Result<AccountDomain> = runCatching {
        accountDataSource.findByUsername(username).require()
    }

    override suspend fun existsByUsername(username: String): Boolean {
        return accountDataSource.existsByUsername(username)
    }

    override suspend fun updateAccount(id: Int, username: String): Result<AccountDomain> = runCatching {
        if (accountDataSource.existsByUsernameEqAndIdNotEq(username, id)) {
            throw ResourceNotFoundException("Username already used")
        }

        accountDataSource.save(id) {
            this.username = username
        }

        accountDataSource
            .findById(id)
            .require()
    }

    override suspend fun deleteAccount(id: Int): Result<Unit> = runCatching {
        accountDataSource
            .deleteById(id)
            .let { isDeleted ->
                if (!isDeleted) {
                    throw ResourceNotFoundException("Account is not deleted")
                }
            }
    }
}