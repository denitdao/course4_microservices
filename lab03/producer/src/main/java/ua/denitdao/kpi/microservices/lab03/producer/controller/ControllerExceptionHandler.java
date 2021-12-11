package ua.denitdao.kpi.microservices.lab03.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ua.denitdao.kpi.microservices.lab03.producer.exception.ValidationException;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
    public String resourceNotFoundException(RuntimeException ex, WebRequest request) {
        log.warn(ex.getMessage());
        return ex.getMessage();
    }
}
