package org.ksystem.app.server.mapper

import org.ksystem.app.domain.model.Account
import org.ksystem.app.server.payload.dto.AccountDto

fun Account.toDto() = AccountDto(
    id = idValue,
    username = username,
)