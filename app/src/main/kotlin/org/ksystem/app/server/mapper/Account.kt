package org.ksystem.app.server.mapper

import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.server.payload.dto.AccountDto

fun AccountDomain.toDto() = AccountDto(
    id = idValue,
    username = username,
)