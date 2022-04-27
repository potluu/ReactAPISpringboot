package com.ecommerce.project.laptop.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.processing.FilerException;
import java.util.zip.DataFormatException;
@RestControllerAdvice
@Log4j2
public class DataExceptionHandler {

    @ExceptionHandler(FilerException.class)
    public ResponseEntity<?> handlerDataFormatException(Exception e){
        log.debug("File error"+e.getMessage());
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not file");
    }
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> arithmeticException(ArithmeticException a){
        log.debug("arithemti error"+a.getMessage());
        a.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not file");
    }
}
