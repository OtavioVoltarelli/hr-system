package com.example.hr_system.infra.exceptionsHandler;

import com.example.hr_system.exceptions.NoActiveContractException;
import com.example.hr_system.exceptions.ObjectNotFoundException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    private ResponseEntity<RestErrorMessage> ObjectNotFoundHandler(ObjectNotFoundException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(NoActiveContractException.class)
    private ResponseEntity<RestErrorMessage> NoActiveContractHandler(NoActiveContractException e){
        String message = "Any active contract found.";
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<RestErrorMessage> DuplicatedValueHandler(DataIntegrityViolationException ex) {
        String message = "Value already exists. " + ex.getMessage();
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.CONFLICT, message);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorMessage);
    }

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<RestErrorMessage> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
//        String errorMessage = "Invalid request body. Please check the format of the input.";
//        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, errorMessage);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErrorMessage);
//    }
}
