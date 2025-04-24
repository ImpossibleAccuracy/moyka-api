package org.ksystem.app.server.payload.request

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateAccountRequest(
    @field:JsonProperty("username")
    val username: String
)