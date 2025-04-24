package org.ksystem.app.data.datasource

import org.ksystem.app.data.database.dao.OrderDao
import org.ksystem.app.data.model.OrderEntity
import org.ksystem.app.domain.model.OrderDomain

class OrderDataSource : CrudDataSource<OrderDomain, OrderEntity>(OrderDao)