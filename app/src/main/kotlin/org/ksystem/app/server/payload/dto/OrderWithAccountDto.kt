package org.ksystem.app.server.payload.dto

data class OrderWithAccountDto(
    val order: OrderDto,
    val creator: AccountDto,
    val service: ServiceDto,
)
