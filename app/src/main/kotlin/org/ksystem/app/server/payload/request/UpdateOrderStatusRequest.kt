package org.ksystem.app.server.payload.request

import com.fasterxml.jackson.annotation.JsonProperty
import org.ksystem.app.domain.model.Id

data class UpdateOrderStatusRequest(
    @field:JsonProperty("order_id")
    var orderId: Id,
    @field:JsonProperty("status")
    var status: String,
    @field:JsonProperty("reject_reason")
    var rejectReason: String? = null,
)