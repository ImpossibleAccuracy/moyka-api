package org.ksystem.app.data.database.table

import org.ksystem.app.data.base.BaseTable

object AccountTable : BaseTable("account") {
    val username = varchar("username", 255)
    val password = varchar("password", 255)
    val firstName = varchar("first_name", 255)
    val middleName = varchar("middle_name", 255)
    val lastName = varchar("last_name", 255)
    val email = varchar("email", 255)
    val phone = varchar("phone", 255)
    val role = varchar("role", 255)
}