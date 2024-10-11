package org.ksystem.app.data.datasource

import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.neq
import org.jetbrains.exposed.sql.and
import org.ksystem.app.data.database.dao.AccountDao
import org.ksystem.app.data.database.table.AccountTable
import org.ksystem.app.data.database.utils.exists
import org.ksystem.app.data.database.utils.findSingle
import org.ksystem.app.data.model.AccountEntity
import org.ksystem.app.domain.model.Account
import org.ksystem.app.domain.model.Id
import org.ksystem.app.utils.ioCall

class AccountDataSource : CrudDataSource<Account, AccountEntity>(AccountDao) {
    suspend fun existsByUsername(username: String): Boolean = ioCall {
        AccountDao.exists(AccountTable.username eq username)
    }

    suspend fun existsByUsernameEqAndIdNotEq(username: String, id: Id): Boolean = ioCall {
        AccountDao.exists(
            (AccountTable.username eq username) and
                    (AccountTable.id neq id)
        )
    }

    suspend fun findByUsername(username: String): Account? = ioCall {
        AccountDao.findSingle(AccountTable.username eq username)
    }
}