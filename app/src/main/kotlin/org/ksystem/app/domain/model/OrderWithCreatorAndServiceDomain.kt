package org.ksystem.app.domain.model

data class OrderWithCreatorAndServiceDomain(
    val order: OrderDomain,
    val creator: AccountDomain,
    val service: ServiceDomain,
)
