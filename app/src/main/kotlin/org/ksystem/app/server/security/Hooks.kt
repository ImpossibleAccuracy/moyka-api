package org.ksystem.app.server.security

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import org.ksystem.app.domain.exception.ServiceException
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.server.model.AccountPrincipal

fun ApplicationCall.requireAccount(): AccountDomain = principal<AccountPrincipal>()?.account
    ?: throw ServiceException("Unauthorized", HttpStatusCode.Unauthorized.value)
