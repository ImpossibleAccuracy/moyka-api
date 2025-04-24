package org.ksystem.app.data.repository

import kotlinx.datetime.LocalDateTime
import org.ksystem.app.data.datasource.OrderDataSource
import org.ksystem.app.domain.exception.InvalidInputException
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.model.Id
import org.ksystem.app.domain.model.OrderDomain
import org.ksystem.app.domain.model.OrderWithCreatorAndServiceDomain
import org.ksystem.app.domain.repository.OrderRepository
import org.ksystem.app.domain.repository.ServicesRepository

class OrderRepositoryImpl(
    private val orderDataSource: OrderDataSource,
    private val serviceRepository: ServicesRepository,
) : OrderRepository {
    override suspend fun create(
        account: AccountDomain,
        serviceId: Id,
        address: String,
        contacts: String,
        deliveryDate: LocalDateTime,
        paymentType: String,
    ): OrderDomain {
        if (!serviceRepository.exists(serviceId)) {
            throw InvalidInputException("Service not found")
        }

        return orderDataSource.save {
            this.accountId = account.idValue
            this.serviceId = serviceId
            this.address = address
            this.contacts = contacts
            this.deliveryDate = deliveryDate
            this.paymentType = paymentType
            this.status = ""
        }
    }

    override suspend fun getAll(): List<OrderWithCreatorAndServiceDomain> =
        orderDataSource.getAllWithCreators()

    override suspend fun getByAccount(account: AccountDomain): List<OrderDomain> =
        orderDataSource.getByAccountId(account.idValue)

    override suspend fun getById(id: Id): OrderDomain? =
        orderDataSource.findById(id)

    override suspend fun updateStatus(
        account: AccountDomain,
        order: OrderDomain,
        newStatus: String,
        rejectReason: String?
    ) {
        orderDataSource.save(id = order.idValue) {
            this.status = newStatus
            this.rejectReason = rejectReason
        }
    }
}