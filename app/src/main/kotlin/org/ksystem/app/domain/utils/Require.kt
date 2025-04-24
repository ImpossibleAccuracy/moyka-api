package org.ksystem.app.domain.utils

import org.ksystem.app.domain.exception.ResourceNotFoundException
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.model.OrderDomain
import org.ksystem.app.domain.model.ServiceDomain

fun AccountDomain?.require(): AccountDomain =
    require("Account not found")

fun OrderDomain?.require(): OrderDomain =
    require("Order not found")

fun ServiceDomain?.require(): ServiceDomain =
    require("Service not found")

private fun <T> T?.require(message: String): T {
    return this ?: throw ResourceNotFoundException(message)
}
