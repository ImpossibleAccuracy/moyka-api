package org.ksystem.app.server.payload.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ksystem.app.domain.model.Id

@Serializable
data class UpdateOrderStatusRequest(
    @SerialName("order_id")
    var orderId: Id,
    @SerialName("status")
    var status: String,
    @SerialName("reject_reason")
    var rejectReason: String? = null,
)