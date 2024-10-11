package org.ksystem.app.data.database.table

import org.ksystem.app.data.base.BaseTable

object AccountTable : BaseTable("account") {
    val username = varchar("username", 255)
    val password = varchar("password", 255)
}