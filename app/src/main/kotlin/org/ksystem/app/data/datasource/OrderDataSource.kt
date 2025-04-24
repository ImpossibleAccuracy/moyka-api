package org.ksystem.app.data.datasource

import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.ksystem.app.data.database.dao.OrderDao
import org.ksystem.app.data.database.table.OrderTable
import org.ksystem.app.data.model.OrderEntity
import org.ksystem.app.domain.model.Id
import org.ksystem.app.domain.model.OrderDomain
import org.ksystem.app.utils.ioCall

class OrderDataSource : CrudDataSource<OrderDomain, OrderEntity>(OrderDao) {
    suspend fun getByAccountId(accountId: Id) = ioCall {
        OrderDao
            .find(OrderTable.accountId eq accountId)
            .orderBy(OrderTable.id to SortOrder.DESC)
            .toList()
    }
}