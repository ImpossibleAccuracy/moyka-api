package org.ksystem.app.data.database.table.refs

import org.jetbrains.exposed.sql.Table
import org.ksystem.app.data.database.table.AccountTable
import org.ksystem.app.data.database.table.RoleTable

object AccountRoleRef : Table("role_account") {
    val account = reference("account_id", AccountTable)
    val role = reference("role_id", RoleTable)
}