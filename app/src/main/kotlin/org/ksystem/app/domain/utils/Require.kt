package org.ksystem.app.domain.utils

import org.ksystem.app.domain.exception.ResourceNotFoundException
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.model.OrderDomain

fun AccountDomain?.require(): AccountDomain =
    require("Account not found")

fun OrderDomain?.require(): OrderDomain =
    require("Order not found")

private fun <T> T?.require(message: String): T {
    return this ?: throw ResourceNotFoundException(message)
}
