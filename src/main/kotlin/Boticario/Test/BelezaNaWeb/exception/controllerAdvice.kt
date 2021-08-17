package Boticario.Test.BelezaNaWeb.exception

import Boticario.Test.BelezaNaWeb.controllers.response.ErrorResponse
import Boticario.Test.BelezaNaWeb.extension.ForbiddenException
import Boticario.Test.BelezaNaWeb.extension.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class controllerAdvice {


    @ExceptionHandler(Exception::class)
    fun exceptionHandlerBadRequest(ex:Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            "Bad Request",
        )
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NotFoundException::class)
    fun exceptionHandlerNotFound(ex:NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
        )
        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)

    }
    @ExceptionHandler(ForbiddenException::class)
    fun exceptionHandlerForbidden(ex:ForbiddenException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            HttpStatus.FORBIDDEN.value(),
            ex.message,
        )
        return ResponseEntity(errorResponse, HttpStatus.FORBIDDEN)
    }

}