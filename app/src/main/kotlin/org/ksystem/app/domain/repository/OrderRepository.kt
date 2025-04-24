package org.ksystem.app.domain.repository

import kotlinx.datetime.LocalDateTime
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.model.Id
import org.ksystem.app.domain.model.OrderDomain
import org.ksystem.app.domain.model.OrderWithCreatorAndServiceDomain

interface OrderRepository {
    suspend fun create(
        account: AccountDomain,
        serviceId: Id,
        address: String,
        contacts: String,
        deliveryDate: LocalDateTime,
        paymentType: String,
    ): OrderDomain

    suspend fun getAll(): List<OrderWithCreatorAndServiceDomain>

    suspend fun getByAccount(account: AccountDomain): List<OrderDomain>

    suspend fun getById(id: Id): OrderDomain?

    suspend fun updateStatus(
        account: AccountDomain,
        order: OrderDomain,
        newStatus: String,
        rejectReason: String?,
    )
}