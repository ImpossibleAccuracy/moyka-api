package org.ksystem.app.server.payload.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountDto(
    @SerialName("id")
    val id: RemoteId,
    @SerialName("username")
    val username: String,
)