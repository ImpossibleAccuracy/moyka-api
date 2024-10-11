package org.ksystem.app.data.database.setup

import com.zaxxer.hikari.HikariConfig
import org.ksystem.app.domain.model.properties.DatabaseProperties

private const val MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver"

private const val TRANSACTION_ISOLATION = "TRANSACTION_READ_COMMITTED"

fun createHikariConfig(properties: DatabaseProperties) =
    HikariConfig().apply {
        jdbcUrl = properties.url
        driverClassName = MYSQL_DRIVER
        username = properties.user
        password = properties.password
        maximumPoolSize = properties.poolSize
        isReadOnly = false
        transactionIsolation = TRANSACTION_ISOLATION
    }
