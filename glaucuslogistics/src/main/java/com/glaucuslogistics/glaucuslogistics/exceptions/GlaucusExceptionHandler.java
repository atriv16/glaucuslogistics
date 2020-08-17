package com.glaucuslogistics.glaucuslogistics.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.SQLException;

@EnableWebMvc
@ControllerAdvice
public class GlaucusExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(GlaucusExceptionHandler.class);

    @ExceptionHandler(SQLException.class)
    protected ResponseEntity glaucusSqlExceptionHandler(Exception ex) {
        LOGGER.error(ex.getMessage());
        return new ResponseEntity("Some Error Occurred while running SQL. Please retry", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity glaucusRMExceptionHandler(Exception ex) {
        LOGGER.error(ex.getMessage());
        return new ResponseEntity("Some Error Occurred while processing request", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity glaucusExceptionHandler(Exception ex) {
        LOGGER.error(ex.getMessage());
        return new ResponseEntity("Some Error Occurred. Please try again", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
