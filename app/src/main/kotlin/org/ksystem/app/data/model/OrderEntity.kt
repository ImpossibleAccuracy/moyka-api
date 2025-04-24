package org.ksystem.app.data.model

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.EntityID
import org.ksystem.app.data.base.ModelImpl
import org.ksystem.app.data.database.table.OrderTable
import org.ksystem.app.domain.model.Id
import org.ksystem.app.domain.model.OrderDomain

class OrderEntity(id: EntityID<Id>) : OrderDomain, ModelImpl(id, OrderTable) {
    private var accountIdEntity by OrderTable.accountId
    override var accountId: Id
        get() = accountIdEntity.value
        set(value) {
            accountIdEntity._value = value
        }

    private var serviceIdEntity by OrderTable.serviceId
    override var serviceId: Id
        get() = serviceIdEntity.value
        set(value) {
            serviceIdEntity._value = value
        }

    override var address: String by OrderTable.address
    override var contacts: String by OrderTable.contacts
    override var deliveryDate: LocalDateTime by OrderTable.deliveryDate
    override var paymentType: String by OrderTable.paymentType
    override var status: String by OrderTable.status
    override var rejectReason: String? by OrderTable.rejectReason
}