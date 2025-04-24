package org.ksystem.app.data.database.dao

import org.ksystem.app.data.base.BaseDao
import org.ksystem.app.data.database.table.AccountTable
import org.ksystem.app.data.database.table.OrderTable
import org.ksystem.app.data.database.table.ServiceTable
import org.ksystem.app.data.model.AccountEntity
import org.ksystem.app.data.model.OrderEntity
import org.ksystem.app.data.model.ServiceEntity

object AccountDao : BaseDao<AccountEntity>(AccountTable, AccountEntity::class)

object ServiceDao : BaseDao<ServiceEntity>(ServiceTable, ServiceEntity::class)

object OrderDao : BaseDao<OrderEntity>(OrderTable, OrderEntity::class)
