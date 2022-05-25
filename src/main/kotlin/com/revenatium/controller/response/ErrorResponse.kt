package com.revenatium.controller.response

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class ErrorResponse(status: HttpStatus, message: String) {
    var code: String? = status.name
    var status: Int? = status.value()
    var message: String? = message
    var timestamp: LocalDateTime = LocalDateTime.now()
}
