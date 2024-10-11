package org.ksystem.app.domain.exception

open class ServiceException(
    message: String,
    val status: Int,
) : RuntimeException(message)