package org.ksystem.app.server.payload.request

import com.fasterxml.jackson.annotation.JsonProperty

data class SignUpRequest(
    @field:JsonProperty("username")
    val username: String,
    @field:JsonProperty("password")
    val password: String,
    @field:JsonProperty("firstName")
    val firstName: String,
    @field:JsonProperty("middleName")
    val middleName: String?,
    @field:JsonProperty("lastName")
    val lastName: String,
    @field:JsonProperty("email")
    val email: String,
    @field:JsonProperty("phone")
    val phone: String,
)