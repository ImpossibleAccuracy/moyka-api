package org.ksystem.app.data.database.setup

import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.ksystem.app.domain.model.properties.DatabaseProperties

fun createDatabase(properties: DatabaseProperties): Database {
    val config = createHikariConfig(properties)

    val dataSource = HikariDataSource(config)

    return Database.connect(
        datasource = dataSource,
    )
}
