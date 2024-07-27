package com.mbtcoding.couchbasedemo.handler;

import com.mbtcoding.couchbasedemo.exception.BookNotFoundException;
import com.mbtcoding.couchbasedemo.model.api.response.base.BaseErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<BaseErrorResponse> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {

        BaseErrorResponse baseErrorResponse = new BaseErrorResponse();

        baseErrorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        baseErrorResponse.setMessage(ex.getMessage());

        return new ResponseEntity<>(baseErrorResponse, HttpStatusCode.valueOf(baseErrorResponse.getErrorCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
