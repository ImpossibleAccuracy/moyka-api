package org.ksystem.app.domain.model

import kotlinx.datetime.LocalDateTime
import org.ksystem.app.domain.model.base.BaseModel

interface OrderDomain : BaseModel {
    var accountId: Id
    var serviceId: Id
    var address: String
    var contacts: String
    var deliveryDate: LocalDateTime
    var paymentType: String
    var status: String
}
