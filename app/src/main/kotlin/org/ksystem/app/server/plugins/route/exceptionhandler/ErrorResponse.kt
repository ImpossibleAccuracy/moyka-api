package org.ksystem.app.server.plugins.route.exceptionhandler

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents

data class ErrorResponse(
    @field:JsonProperty("timestamp")
    val timestamp: String = now().format(DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET),
    @field:JsonProperty("message")
    val message: String,
)