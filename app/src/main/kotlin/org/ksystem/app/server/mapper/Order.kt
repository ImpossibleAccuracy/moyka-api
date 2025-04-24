package org.ksystem.app.server.mapper

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import org.ksystem.app.domain.model.OrderDomain
import org.ksystem.app.server.payload.dto.OrderDto

fun OrderDomain.toDto() = OrderDto(
    id = idValue,
    accountId = accountId,
    serviceId = serviceId,
    address = address,
    contacts = contacts,
    deliveryDate = deliveryDate.toInstant(TimeZone.UTC).toEpochMilliseconds(),
    paymentType = paymentType,
    status = status,
    rejectReason = rejectReason
)