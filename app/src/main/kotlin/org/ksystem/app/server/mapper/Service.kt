package org.ksystem.app.server.mapper

import org.ksystem.app.domain.model.ServiceDomain
import org.ksystem.app.server.payload.dto.ServiceDto

fun ServiceDomain.toDto() = ServiceDto(
    id = idValue,
    name = name,
)