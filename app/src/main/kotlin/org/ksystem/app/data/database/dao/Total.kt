package org.ksystem.app.data.database.dao

import org.ksystem.app.data.model.RoleEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.ksystem.app.data.base.BaseDao
import org.ksystem.app.data.database.table.AccountTable
import org.ksystem.app.data.database.table.RoleTable
import org.ksystem.app.data.model.AccountEntity

object AccountDao : BaseDao<AccountEntity>(AccountTable, AccountEntity::class)

object RoleDao : IntEntityClass<RoleEntity>(RoleTable, RoleEntity::class.java)
