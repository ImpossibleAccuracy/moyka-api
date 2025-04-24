package org.ksystem.app.data.database.table

import org.ksystem.app.data.base.BaseTable

object ServiceTable : BaseTable("service") {
    val name = varchar("name", 255)
}