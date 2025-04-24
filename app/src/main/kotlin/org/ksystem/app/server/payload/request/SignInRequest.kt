package org.ksystem.app.server.payload.request

import com.fasterxml.jackson.annotation.JsonProperty

data class SignInRequest(
    @field:JsonProperty("username")
    val username: String,
    @field:JsonProperty("password")
    val password: String,
)