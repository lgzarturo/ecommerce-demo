package com.revenatium.exceptions

import com.revenatium.controller.response.ErrorResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ControllerExceptionHandler : ResponseEntityExceptionHandler() {
    private var log: Logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(EntityNotExistException::class)
    fun handlerEntityNotExistException(ex: EntityNotExistException, request: WebRequest): ResponseEntity<ErrorResponse> {
        log.error("La entidad no existe", ex.message)
        val message = "La entidad no existe"
        val status = HttpStatus.NOT_FOUND
        return ResponseEntity(ErrorResponse(status, message), status)
    }
}
