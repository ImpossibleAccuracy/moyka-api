package org.ksystem.app.domain.utils

import org.ksystem.app.domain.exception.ResourceNotFoundException
import org.ksystem.app.domain.model.Account

fun Account?.require(): Account =
    require("Account not found")

private fun <T> T?.require(message: String): T {
    return this ?: throw ResourceNotFoundException(message)
}
