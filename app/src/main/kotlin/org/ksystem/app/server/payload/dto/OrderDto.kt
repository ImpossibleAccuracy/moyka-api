package org.ksystem.app.server.payload.dto

import org.ksystem.app.domain.model.Id

data class OrderDto(
    var id: Id,
    var accountId: Id,
    var serviceId: Id,
    var address: String,
    var contacts: String,
    var deliveryDate: Long,
    var paymentType: String,
    var status: String,
    var rejectReason: String?,
)
