package org.ksystem.app.data.database.table

import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import org.ksystem.app.data.base.BaseTable

object OrderTable : BaseTable("order") {
    val accountId = reference("account_id", AccountTable)
    val serviceId = reference("service_id", ServiceTable)
    val address = varchar("address", 255)
    val contacts = varchar("contacts", 255)
    val deliveryDate = datetime("delivery_date")
    val paymentType = varchar("payment_type", 255)
    val status = varchar("status", 255)
    val rejectReason = varchar("reject_reason", 255).nullable()
}