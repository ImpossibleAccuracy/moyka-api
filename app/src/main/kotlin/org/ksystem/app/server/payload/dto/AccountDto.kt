package org.ksystem.app.server.payload.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AccountDto(
    @field:JsonProperty("id")
    val id: RemoteId,
    @field:JsonProperty("username")
    val username: String,
    @field:JsonProperty("firstName")
    var firstName: String,
    @field:JsonProperty("middleName")
    var middleName: String,
    @field:JsonProperty("lastName")
    var lastName: String,
    @field:JsonProperty("email")
    var email: String,
    @field:JsonProperty("phone")
    var phone: String,
    @field:JsonProperty("role")
    var role: String,
)