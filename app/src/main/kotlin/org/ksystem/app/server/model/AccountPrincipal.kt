package org.ksystem.app.server.model

import io.ktor.server.auth.*
import org.ksystem.app.domain.model.AccountDomain

data class AccountPrincipal(
    val account: AccountDomain,
) : Principal
