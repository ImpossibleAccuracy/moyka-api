package org.ksystem.app.server.payload.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ksystem.app.server.payload.dto.RemoteId

@Serializable
data class AuthResponse(
    @SerialName("id")
    val id: RemoteId,
    @SerialName("token")
    val token: String,
)