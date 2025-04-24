package org.ksystem.app.server.payload.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ksystem.app.domain.model.Id

@Serializable
data class CreateOrderRequest(
    @SerialName("service_id")
    var serviceId: Id,
    @SerialName("address")
    var address: String,
    @SerialName("contacts")
    var contacts: String,
    @SerialName("delivery_date")
    var deliveryDate: String,
    @SerialName("payment_type")
    var paymentType: String,
)