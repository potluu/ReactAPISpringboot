package com.ecommerce.project.laptop.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class ErrorExceptionSystem {

    @ExceptionHandler(OutOfMemoryError.class)
    public ResponseEntity<?> vutOfMemoryError(OutOfMemoryError outOfMemoryError){
        log.debug("System error outOfMemoryError "+outOfMemoryError.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error system");
    }
    @ExceptionHandler(VirtualMachineError.class)
    public ResponseEntity<?> virtualMachineError(VirtualMachineError v){
        log.debug("System error  VirtualMachineError:"+v.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error system");
    }
    @ExceptionHandler(StackOverflowError.class)
    public ResponseEntity<?> stackOverflowError(StackOverflowError stackOverflowError){
        log.debug("System error stackOverflowError:"+stackOverflowError.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error system");
    }

}
