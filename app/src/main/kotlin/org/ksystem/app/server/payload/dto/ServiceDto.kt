package org.ksystem.app.server.payload.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.ksystem.app.domain.model.Id

data class ServiceDto(
    @field:JsonProperty("id")
    val id: Id,
    @field:JsonProperty("name")
    val name: String,
)
