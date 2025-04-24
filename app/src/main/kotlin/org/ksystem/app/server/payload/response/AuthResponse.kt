package org.ksystem.app.server.payload.response

import com.fasterxml.jackson.annotation.JsonProperty
import org.ksystem.app.server.payload.dto.RemoteId

data class AuthResponse(
    @field:JsonProperty("id")
    val id: RemoteId,
    @field:JsonProperty("token")
    val token: String,
)