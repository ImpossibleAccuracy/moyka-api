package org.ksystem.app.server.payload.request

import com.fasterxml.jackson.annotation.JsonProperty
import org.ksystem.app.domain.model.Id

data class CreateOrderRequest(
    @field:JsonProperty("service_id")
    var serviceId: Id,
    @field:JsonProperty("address")
    var address: String,
    @field:JsonProperty("contacts")
    var contacts: String,
    @field:JsonProperty("delivery_date")
    var deliveryDate: Long,
    @field:JsonProperty("payment_type")
    var paymentType: String,
)