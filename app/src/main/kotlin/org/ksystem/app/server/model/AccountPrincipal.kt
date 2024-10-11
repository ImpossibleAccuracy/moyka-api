package org.ksystem.app.server.model

import io.ktor.server.auth.*
import org.ksystem.app.domain.model.Account

data class AccountPrincipal(
    val account: Account,
) : Principal
